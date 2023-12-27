## java -> kotlin 세팅하기
<br/>

| 코틀린의 클래스는 기본적으로 final 이라서 상속이 불가능하므로 open class 로 만들어 주어야 함.
하지만 모든 클래스마다 open 키워드를 붙이는 건 번거로울 수 있으므로 build.gradle 에서 설정 가능
plugin 등록
id ("org.jetbrains.plugin.allopen") version "1.6.21"

그다음 allOpen { annotation ("어노테이션 주소까지 다 붙여넣기") } 설정

하지만 이 방법도 새로운 annotation 을 사용할 때마다 계속 추가해줘야하기 때문에 불편
plugin 등록
kotlin("plugin.spring") version "1.6.21"
하면 클래스나 어노테이션 추가하지 않아도 open 키워드 없이 자동으로 open 처리 해줌. 컴파일 오류 x

Entity annotation 을 사용하려면 no-arg 가 필수적이라
플러그인 추가해서 등록
kotlin("plugin.noarg") version "1.6.21"
noArg {
	annotation("jakarta.persistence.Entity")
}

하지만 이것도 일일이 등록하기 불편하므로 코틀린 JPA 플로그인을 제공함

	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"

이 두가지 플러그인에 대해서는 필수적이라고 생각하면 됨.
