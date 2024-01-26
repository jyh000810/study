# JAVA

### 1. [객체지향 프로그래밍](#1-객체지향-프로그래밍-1)
### 2. [JVM](#2-JVM-1)

<br>

## 1. 객체지향 프로그래밍

### 객체지향이란..
   객체지향 프로그래밍은 소프트웨어를 개발하는 프로그래밍 패러다임 중 하나로 상태(Field)와 행위(Method)로 이루어진<br>객체들간의 상호작용을 기반으로 프로그램을 설계 및 개발하는 것입니다. 

<br>

### 객체지향의 장점

* 코드 재사용성
* 유지보수성
* 확장성
* 정보 은닉

<br>

### JAVA의 객체지향 특징

* **클래스 (Class)**
   * 객체를 정의하는 틀이며 필드와 메소드로 구성됩니다. 클래스는 여러 객체를 생성하기 위한 설계도로 생각할 수 있습니다.
```JAVA
class Car {
    // 필드
    String name;
    int speed;

    // 메소드
    public void move() {}

}
```
<br>

* **객체 (Object)**
  * 객체는 클래스의 인스턴스로 실제로 메모리에 할당된 데이터입니다. 객체는 클래스에서 정의한 필드와 메소드를 가집니다.
```JAVA

Car car = new Car(); // new 연산자를 통해 클래스 타입의 인스턴스 생성 및 참조값 Return
car.move();

```
<br>

* **상속 (Inheritance)**
  * 상속은 부모 클래스의 특성을 자식 클래스가 물려받는 개념입니다. 코드의 재사용성을 높이고 계층 구조를 형성하여<br>유지보수성을 개선합니다.
```JAVA

public class Main {
        public static void main(String[] args) {

            SUV suv = new SUV();
            suv.시동();

        }
}

class Car {
    public void 시동() {
        System.out.println("시동을 겁니다.");
    }
}

class SUV extends Car {

    String name;
    int speed;

}

```

<br>

* **다형성 (Polymorphism)**
  *  다형성이란 서로 다른 타입의 객체를 동일한 인터페이스나 부모 클래스를 사용하여 통일적으로 다룰 수 있는 개념으로<br>코드의 유연성과 확장성을 높입니다.

```JAVA
public class Main {
        public static void main(String[] args) {

            Car suv = new SUV(); // 업캐스팅을 통해
            Car van = new VAN(); // 부모 타입 변수에 자식 인스턴스 전달

            suv.시동();
            van.시동();

        }
}

class Car {
    public void 시동() {
        System.out.println("시동을 겁니다.");
    }
}

class SUV extends Car {

    String name;
    int speed;

    @Override
    public void 시동() {
        System.out.println("SUV 시동을 겁니다.");
    }

    public void 시동(String name) {
        System.out.println(name);
    }

}

class VAN extends Car {

    String name;
    int speed;

    @Override
    public void 시동() {
        System.out.println("VAN 시동을 겁니다.");
    }

    public void 시동(String name) {
        System.out.println(name);
    }

}
```
<br>

* **캡슐화 (Encapsulation)**
  * 데이터와 그 데이터를 다루는 메서드들을 하나로 묶고 외부에서 직접적인 접근을 제한하는 것을 의미합니다.<br>이를 통해 객체 상태를 은닉하고 외부에서는 객체의 행동만을 노출시킴으로써 정보 은닉과 결합도를 낮춰 확장성을 높일 수 있습니다.
 
```JAVA
public class Main {
        public static void main(String[] args) {

            SUV suv = new SUV();
            VAN van = new VAN();

            // set메소드를 데이터에 간접적으로 접근
            suv.setName("SUV");
            van.setName("VAN");

            suv.시동();
            van.시동();

        }
}

class Car {
    public void 시동() {
        System.out.println("시동을 겁니다.");
    }
}

class SUV extends Car {

    private String name; // private으로 접근 제한
    private int speed; // private으로 접근 제한

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void 시동() {
        System.out.println(name + " 시동을 겁니다.");
    }

}

class VAN extends Car {

    private String name; // private으로 접근 제한
    private int speed; // private으로 접근 제한

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void 시동() {
        System.out.println(name + " 시동을 겁니다.");
    }

}
```
<br>

* **추상화 (Abstraction)**
   * 추상화는 객체의 공통적인 특성을 추출하여 인터페이스나 추상 클래스로 정의하는 것을 말합니다.<br>추상화를 통해 객체의 복잡한 내부 구현을 숨기고 객체 간의 관계를 단순화하며 가독성을 높일 수 있습니다.


```JAVA
public class Main {
        public static void main(String[] args) {

            SUV suv = new SUV();
            VAN van = new VAN();

            suv.충전();
            van.충전();

        }
}

abstract class Car {

    abstract void 충전(); // 공통된 특성 정의

}

class SUV extends Car {

    private String name;
    private int speed;

    @Override
    void 충전() {
        System.out.println("전기를 이용해 충전합니다.");
    }

}

class VAN extends Car {

    private String name;
    private int speed;

    @Override
    void 충전() {
        System.out.println("휘발유를 이용해 충전합니다.");
    }
}
```
<br>

## 2. JVM

### 자바는 운영체제에 왜 독립적인가

![image](https://github.com/JustBasicPro/Study/assets/38283489/01669041-9ed3-4360-b168-97d725f8dc8a)

### JDK

* 자바를 사용하여 소프트웨어를 개발하기 위한 도구와 라이브러리를 제공하는 패키지입니다.
* 자바를 바이트 코드로 컴파일 해주는 javac, 디버깅을 도와주는 jdb, jar 파일 생성해주는 jar 등 여러가지 도구가 있습니다.

### JRE

* 자바로 만들어진 애플리케이션을 실행하는 데 필요한 런타임 환경을 제공합니다. 
* 콘솔 기반 앱을 실행하는 java, GUI 기반의 앱을 실행하는 javaw 등 여러가지 도구가 있습니다.
* 자바 표준 라이브러리와 클래스 파일이 포함되어 있어 효율적인 개발을 지원합니다.

### JVM

* Interpreter와 JIT Compiler을 통해 바이트 코드를 운영체제에 맞는 기계어로 변환이 가능합니다.
* Garbage Collector를 통해 애플리케이션의 동적 메모리를 효율적으로 관리합니다.
* 다중 스레드를 통해 여러 스레드를 동시에 실행하고 관리하여 병렬 처리를 할 수 있습니다. 

<br>

## JVM 구조

![image](https://github.com/JustBasicPro/Study/assets/38283489/b69aaef3-8b5b-4ee2-8c80-fa3e527b04ec)

### Class Loader
* .class 파일들을 필요한 순간에 동적으로 로드하여 메모리에 적재를 할 수 있습니다.


### Excution Engine
* Class Loader에 의해 메모리에 적재된 .class 파일을 기계어로 변경해 명령어 단위로 실행하는 역할을 합니다.
* Interpreter - 바이트 코드를 한줄 씩 읽어서 Native Code로 변환한다. 하지만 반복되는 코드들에 대해서도 매번 작업을 하기에 비효율적인 면이 있습니다.
* JIT Compiler - Interpreter의 단점을 보완하기 위해 나온 방식으로 반복되는 코드들을 전부 Native Code로 컴파일한 뒤 캐싱하여 호출이 될 때 불러다가 사용합니다

### Runtime Data Area
* JVM이 프로그램을 실행하는 동안 필요한 데이터들을 저장하는 영역입니다.
* Method Area - 모든 스레드가 공유하는 메모리 영역으로 인스턴스 생성을 위한 클래스와 메소드의 정보, static 변수, 상수, 메소드 코드 등이 저장됩니다.
* Heap Area - 동적으로 할당된 인스턴스와 배열이 저장되는 공간으로 자바의 new 키워드를 통해 생성된 객체들이 여기에 할당됩니다.
* Stack Area - 각각의 스레드마다 생성되는 영역으로 메소드 호출과 관련된 정보가 저장됩니다. 각 메소드 호출마다 스택 프레임이 생성되어 지역 변수, 매개변수, 임시 데이터 등이 저장되며 메소드 실행이 끝나면 해당 스택 프레임이 제거됩니다.
* PC Register - 현재 수행 중인 명령어의 주소를 가지고 있습니다. 스레드는 PC Register를 통해 다음에 수행할 명령어를 알 수 있습니다.
* Native Method Stack - 자바 이외의 언어로 작성된 네이티브 코드(C, C++)를 호출하는 경우 해당 스레드의 네이티브 메서드 호출 정보가 저장되는 영역입니다.

### Garbage Collector
* Heap Area에서 더 이상 사용되지 않는 인스턴스를 찾아 메모리를 정리합니다.
* 객체지향 프로그래밍에서 중요한 역할로 자바의 메모리 관리를 자동화하여 개발자가 명시적으로 메모리를 해제하지 않아도 되게 합니다. 이를 통해 메모리 누수를 방지하고 프로그램의 안정성과 효율성을 향상시킵니다.

