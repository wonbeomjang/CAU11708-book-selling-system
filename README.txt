## 실행 방법
java -jar out/artifacts/bookselling_jar/bookselling.jar

## 목록
1. JAVA Code
    - src/main

2. Test Code
    - src/test

3. Class Code (binary code)
    - target/classes
    * 주의: Jackson 라이브러리를 사용하고 있어 Main 실행이 안됨 (5번 참조) *

4. Test Class Code (binary code)
    - target/test-classes
    * 주의: JUnit5 Jackson 라이브러리를 사용하고 있어 Main 실행이 안됨 IntelliJ에서 작업 가능 *

5. Jar file (binary code)
    - out/artifacts/bookselling_jar/bookselling.jar
    - 실행방법
        java -jar out/artifacts/bookselling_jar/bookselling.jar

6. 프로젝트 문서
    - report.pdf

7. Data file
    - data/user.json // User 데이터 파일
    - data/book.json // 책 데이터 파일 (자동생성)
    - data/userTest.json // User 테스트 데이터 파일 (자동생성)
    - data/bookTest.json // 책 테스트 데이터 파일 (자동생성)