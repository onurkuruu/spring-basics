## Spring Framework

**Spring Framework** güçlü **java uygulamaları** hazırlamak için, alt yapı sunan hızlı geliştirme yapmayı sağlayan açık kaynak frameworktür.

**Spring**’ in faydaları

* **EJB** konteynerine gerek olmadan çalışabilir.
* Bir çok modülü sayesinde çoğu alt yapı işini geliştiricilerden alır.
* Kolay test edilebilir bir yapı sağlar.
* **EJB**’ ye göre çok hafif olan **IoC** container sağlar.

### Spring Mimarisi

**Spring**, core container ve onu çevreleyen kolayca entegre olabilen modüllerden oluşur. Core Container; Core, Beans, Context ve Expression Language modüllerinden oluşur.

* **Core** modülü framework için temel işlevleri sağlar. **Dependency Injection** ve **IoC** özellikleri üzerine inşa edilmiştir. 
* **Bean** modülü **BeanFactory** ile alakalı arayüzleri ve sınıfları sağlar.
* **Context** modülü **Core** ve **Bean** modülleri için alt yapı sağlar ve gerekli nesnelere buradan erişelebilir.

### Spring IoC Container ve Dependency Injection

**Spring container**, **Spring Framework**’ ün temelini oluşturur. Bu konteyner sayesinde beanlerin yönetimi sağlanır, birbirlerine bağlanır, yaşam döngülerinin kontrolü sağlanır. Bu işlemleri **Dependency Injection** sayesinde yapar.

**IoC** nesne yönetim işlemlerinin geliştiriciden alınıp frameworke devredilmesidir. **DI** ise bunu gerçekleştirmek için bir yöntemdir.[Daha detaylı bilgi için](https://github.com/onurkuruu/java-solid#dependency-inversion-principle)

### Spring Bean

Uygulamaların temelini oluşturur ve yönetimleri **Spring IoC Container** tarafından sağlanır.

#### Bean Scopes
Bu kapsamlar sayesinde beanlerin yaşam döngüleri belirlenir ve yönetimleri sağlanır.

* **singleton**: Sadece bir defa oluşturulur ve bean istenildiği zaman hep aynı nesne döndürülür. Default scope singletondır.
* **prototype**: Bu bean tanımı ile sayısız nesne oluşturulması sağlanır. Nesneye yapılan her istekte yeni bir örneği oluşturulur.
* **request, session, global-session**: Sadece web uyumlu **Spring ApplicationContext**’ de geçerlidir. HTTP session tanımlamada kullanılır.

#### Bean Life Cycle

Bir bean, yeni oluşturulup konteynera eklenmiş ya da yok edilip konteynerdan silinmiş olabilir.

* **Bean initialization callbacks**: **InitializingBean** arayüzünden sağlanan **afterPropertiesSet()** fonksiyonu ile sağlanır ya da xml içerisinde tanımlanırken **init-method** özelliği sayesinde farklı bir fonksiyon da belirtilebilir.

```java
public class SpringBean implements InitializingBean {
   public void afterPropertiesSet() {
	System.out.println(“Bean has been created.”);
   }
}
```

ya da

```xml
<bean id = "springBean" class = "com.oonurkuru.spring.SpringBean" init-method = "init"/>
```
```java
public class SpringBean {
   public void init() {
     System.out.println(“Bean has been created.”);
   }
}
```

* **Bean destruction callbacks**: Aynı şekilde bir bean yok edileceği zaman da bir interface yardımıyla ya da xml ayarları sayesinde callback metodu belirtilebilir. **DisposableBean** arayüzünün **destroy()** fonksiyonu kullanılabilir ya da xml’de **destroy-method** özelliği sayesinde metot belirtilebilir.

```java
public class SpringBean implements DisposableBean {
   public void destroy() {
      System.out.println(“Bean has been deleted.”);
   }
}
```
ya da

```xml
<bean id = "springBean" class = "com.oonurkuru.spring.SpringBean" destroy-method = "destroy"/>
```

```java
public class SpringBean {
   public void destroy() {
      System.out.println(“Bean has been deleted.”);
   }
}
```

#### Beanler Arası Kalıtım

Bir bean tanımlanırken yapılandırma ayarları, kurucu argümanlar ve çeşitli özellik tanımlamaları içerir. Bean **Inheritance** ile bu bilgiler alt beanlere aktarılabilir.

```xml
<bean id = "superBean" class = "com.oonurkuru.spring.SuperBean">
      <property name = "property" value = "Property of Super Bean"/>
</bean>

<bean id =" childBean" class = "com.oonurkuru.spring.ChildBean" parent = "superBean"></bean>
```

Beanler soyut olarak tanımlanabilir. Soyut bir beanin örneği oluşturulamaz sadece diğer beanler için şablon oluşturur.

```xml
<bean id = "abstractBean" abstract = "true">
      <property name = "property" value = "Property of Abstract Bean"/>
</bean>

<bean id = "beanImplement" class = "com.oonurkuru.spring.BeanImplement" parent = "abstractBean"></bean>
```

#### Inner Beans

Java’daki inner sınıflar gibi düşünebiliriz. Bean içerisinde bean tanımlayabiliriz.

```java
public class Person{
   private PhoneNumber phoneNumber;
…
}
```

```xml
<bean id = "person" class = "com.oonurkuru.spring.Person">
      <property name = "phoneNumber">
         <bean id = "phoneNumber" class = "com.oonurkuru.spring.PhoneNumber"/>
      </property>
</bean>
```

#### Injecting Collection

Sınıflarımızda tanımlı **List**, **Set**, **Map** ve **Properties** tipindeki değişkenlerimize atama yapabiliriz.

```java
public class Employee{
   
      List projectList;
...
}
```

```xml
<bean id = "employee" class = "com.oonurkuru.spring.Employee">
<property name = "projectList">
         <list>
            <value>Spring Basics</value>
            <value>JPA Basics</value>
         </list>
</property>
</bean>
```

### Java Sınıfları İle Yapılandırma

Spring ayarları **xml** tabanlı yapılabildiği gibi sınıf tabanlı da yapılabilir. **@Configuration** notasyonu ile işaretlenen sınıf, ayarların yapılandırılacağı sınıf olur. 

```java
@Configuration
public class PersonConfig{
   @Bean 
   public Person person(){
      return new Person();
   }
}
```
**@Import** notasyonu ile ayarların yapıldığı bir sınıfı işaret ederek ayarların direkt olarak yüklenmesi sağlanır. xml içerisinde ki ```xml<import></import>``` etiketine benzetilebilir. Aşağıda ki örnekte B sınıfı yüklendiğinde A sınıfı ayarlarıda yüklenir.

```java
@Configuration
public class ConfigA {
   @Bean
   public A a() {
      return new A(); 
   }
}

@Configuration
@Import(ConfigA.class)
public class ConfigB {
   
}
```