# 예제 코드 실행하기(Windows 버전)

## 1. VSCode 설치하기

### VSCode 다운로드 및 설치하기

▼[https://code.visualstudio.com/](https://code.visualstudio.com/)에 접속해 Visual Studio Code(VSCode)를 다운로드하여 설치합니다.

![Visual Studio Code 다운로드](./img/vscode_000.png)

▼설치 옵션은 기본값으로 진행하면 됩니다.

![Visual Studio Code 설치 완료](./img/vscode_001.png)

▼VSCode를 실행하면 한국어 언어 팩을 설치할 수 있다고 알려줍니다. 우측 하단의 버튼을 눌러 '설치 및 다시 시작'합니다.

![한국어 언어 팩 설치](./img/vscode_002.png)

▼자동으로 언어 팩이 설치되어, 재시작된 뒤에는 한글로 화면이 표시됩니다.

![언어 팩 설치 완료](./img/vscode_003.png)

## 2. C 예제 파일 실행 환경 구축하기

### 확장 기능 설치하기

▼좌측의 확장 메뉴나, 키보드 단축키로 (Ctrl+Shift+X)를 눌러 'C++' 키워드로 검색합니다. C/C++ 확장(Microsoft 제작)이 나오면 설치 단추를 누릅니다.

![C, C++ 확장 기능 설치](./img/vscode_005.png)

### 컴파일러(MinGW) 설치하기

▼[https://sourceforge.net/projects/mingw/files/](https://sourceforge.net/projects/mingw/files/)에 접속해 최신 버전을 다운로드합니다.

![MinGW 다운로드](./img/vscode_008.png)

▼MinGW 설치 관리자 셋업 도구가 나타납니다. 'Install' 단추를 누릅니다.

![MinGW 설치](./img/vscode_009.png)

▼설치 옵션은 바꾸지 말고 기본값대로 진행합니다.

![MinGW 설치 옵션](./img/vscode_010.png)

▼다운로드되었다면 'Continue'를 누릅니다.

![MinGW 설치 옵션](./img/vscode_011.png)

▼MinGW 설치 관리자가 나타납니다. 아래 4개의 패키지를 체크하세요.

- mingw-developer-toolkit
- mingw32-base
- mingw32-gcc-g++
- msys-base

![MinGW 설치 관리자](./img/vscode_012.png)

▼MinGW 설치 관리자 메뉴에서 Installation -> Apply Changes를 클릭합니다.

![MinGW 설치 관리자](./img/vscode_013.png)

▼선택한 패키지를 설치하려면 Apply 단추를 누릅니다. 다운로드하고 설치하는 데 꽤 시간이 걸리니 커피 한 잔 마시고 오세요.

![MinGW 설치 관리자](./img/vscode_014.png)

▼설치가 완료되면 Close를 눌러 설치 관리자를 닫으세요.

![MinGW 설치 관리자](./img/vscode_015.png)

### 환경 변수 추가하기

▼시작 메뉴를 눌러 '고급 시스템 설정'을 입력해 '고급 시스템 설정 보기'를 여세요.

![시작 메뉴에서 검색](./img/vscode_016.png)

▼시스템 속성 대화상자가 나타납니다. [고급]탭의 '환경 변수'를 클릭하세요.

![시스템 속성](./img/vscode_017.png)

▼환경 변수 대화상자가 나타납니다. 시스템 변수에 있는 'Path' 항목을 선택하고, [편집] 단추를 누르세요.

![환경 변수](./img/vscode_019.png)

▼환경 변수 편집 대화상자가 나타납니다. [새로 만들기] 단추를 눌러 MinGW를 설치한 경로를 추가하고, [확인] 단추를 누르세요.

    C:\MinGW\bin

![환경 변수 편집](./img/vscode_020.png)

### 컴파일러 설치 확인하기

▼윈도우 키를 눌러 'cmd'를 입력해 '명령 프롬프트'를 실행합니다.

![시작 메뉴에서 검색](./img/vscode_021.png)

▼아래 명령으로 설치된 컴파일러의 버전을 확인하세요. 정상적으로 출력되면 설치가 완료된 것입니다.

    g++ --version
    gdb --version

![환경 변수 편집](./img/vscode_022.png)

## 3. C 예제 파일 실행하기

### C 예제 파일 열기

▼VSCode에서 C/C++ 코드가 위치한 폴더를 엽니다.

![폴더 열기](./img/vscode_006.png)

▼좌측 탐색 창에서 C/C++ 코드를 엽니다.

![파일 열기](./img/vscode_007.png)

### C 예제 파일 빌드하기

▼터미널 -> 빌드 작업 실행을 클릭합니다.

![빌드 작업 실행](./img/vscode_023.png)

▼설치된 컴파일러(MinGW의 GCC)를 선택합니다.

![컴파일러 선택](./img/vscode_024.png)

▼컴파일이 완료되면 하단의 터미널에 결과가 표시됩니다. 좌측 탐색 창을 보면 .exe파일이 추가된 것을 확인할 수 있습니다.

![컴파일 완료](./img/vscode_025.png)

### C 예제 파일 실행하기

▼좌측 탐색 창의 파일을 마우스 오른쪽 단추로 눌러 [통합 터미널에서 열기]를 선택합니다.

![통합 터미널에서 열기](./img/vscode_027.png)

▼실행 파일명을 입력해, 엔터를 누르면 컴파일된 C/C++ 코드가 실행됩니다.

    .\파일명.exe

![실행하기](./img/vscode_028.png)

## 4. Java 예제 파일 실행 환경 구축하기

### Java 확장 기능 설치하기

▼좌측의 확장 메뉴나, 키보드 단축키로 (Ctrl+Shift+X)를 눌러 'java' 키워드로 검색합니다. Extension Pack for Java(Microsoft 제작)가 나오면 설치 단추를 누릅니다.

![Java 확장 기능 설치](./img/vscode_029.png)

### JDK 설치하기

▼처음 Java 파일을 열면 자바 런타일 구성(Configure Java Runtime)이 나타납니다. Install A JDK에서 원하는 버전을 선택한 후, Download 단추를 누르세요.

![자바 런타일 구성](./img/vscode_037.png)

▼JDK를 기본값대로 설치하여, 완료되면 Finish를 누릅니다. VSCode는 재시작하시기 바랍니다.

![JDK 설치 완료](./img/vscode_039.png)

## 5. Java 예제 파일 실행하기

### Java 예제 파일 실행하기

▼Java 파일을 열어 Run(실행) 단추를 누릅니다.

![Java 실행](./img/vscode_040.png)

▼하단 터미널에 Java 파일 실행 결과가 나타납니다.

![Java 실행 완료](./img/vscode_041.png)
