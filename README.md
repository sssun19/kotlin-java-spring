## java -> kotlin 세팅하기
<br/>

<p>:bulb: 코틀린의 클래스는 기본적으로 final 이라서 상속이 불가능하므로 open class 로 만들어 주어야 함.<br/>
하지만 모든 클래스마다 open 키워드를 붙이는 건 번거로울 수 있으므로 build.gradle 에서 설정 가능</p>
<br/>
:bulb: plugin 등록<br/>
id ("org.jetbrains.plugin.allopen") version "1.6.21"<br/>
<br/>
allOpen { annotation ("") } <br/><br/>
:no_good: 하지만 이 방법도 새로운 annotation 을 사용할 때마다 계속 추가해줘야 하기 때문에 불편<br/>
<br/>

 	kotlin("plugin.spring") version "1.6.21"

:ok_woman: 클래스나 어노테이션 추가하지 않아도 open 키워드 없이 자동으로 open 처리 해줌. 컴파일 오류 x <br/>
<br/>
Entity annotation 을 사용하려면 no-arg 가 필수적 -> 플러그인 추가해서 등록 <br/>
<br/>
	
 	kotlin("plugin.noarg") version "1.6.21"
	noArg {
		annotation("jakarta.persistence.Entity")
	}
<br/>
:no_good: 일일이 등록하기 불편하므로 코틀린 JPA 플로그인을 제공함 <br/><br/>

	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"

이 두가지 플러그인에 대해서는 필수적이라고 생각하면 됨.
