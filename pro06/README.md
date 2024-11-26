### http://localhost:8090/프로젝트명/경로 

클래스(서블릿)안에 메서드(doGet, doPost)실행

applet

server + applet = servlet

servlet = java <- html(css, js)
jsp = html <- java

get
- third?a=1&b=2&c=3... 

post
- 주소창x
- 개인정보, 파일

request 객체
- getParameter("이름")
- getParameterValues("이름")
- getSession()

response 객체
- sendRedirect("주소")
- getWriter()
