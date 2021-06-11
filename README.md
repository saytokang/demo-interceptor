# MVC Interceptor example

## 생성 Interceptor
* AccessAuthrorityInterceptor.java
위 클래스에서 보면, preHandler() 에서 해당 기능 수행. 
HttpServletRequest request 에서 

## 등록 interceptor
* InterceptorConfig.java
이 소스에서 중요 부문은 
addInterceptors() 함수의 url pattern  설정이다. 