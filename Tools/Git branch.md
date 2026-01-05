<h1>2강 목차</h1>

### 1. [Git 명령어](#1-Git-명령어-1)
### 2. [Git branch 전략](#2-Git-branch-전략-1)

<br><br>

<h1>1. Git 명령어</h1>
                
![image](https://github.com/JustBasicPro/Study/assets/38283489/c4de1fd9-0264-4fbc-b12a-f59b4a87bf70)

``` add ```  : Workspace의 변경 사항을 Staging Area에 추가합니다.

``` commit ```  : Staging Area에 있는 파일들을 Local Repository에 스냅샷으로 저장합니다.

``` push ```  : Local Repository의 내용을 Remote Repository에 업로드를 합니다.

``` fetch ```  : Remote Repository의 내용을 Local Repository에 다운로드 합니다.

``` pull ```  : fetch와 merge의 조합으로 Remote Repository의 내용을 다운로드 후 일치하도록 Workspace를 업데이트 합니다.

<br><br>

<h1>2. Git branch 전략</h1>

<h3>Q. branch란?</h3>

![image](https://github.com/JustBasicPro/Study/assets/38283489/108e6d22-305b-465f-a3de-9e230cbe0bc6)


branch는 프로젝트의 특정 시점에서의 작업 흐름을 나타내는 참조입니다.

각 브랜치는 프로젝트의 특정 커밋을 가리키며 이 커밋은 프로젝트의 특정 상태를 나타냅니다.

또한 생성 및 전환 시 파일들의 실제 복사가 이루어지지 않고 단순히 커밋을 가리키는 포인터이기에 가볍고 빠릅니다.

<br>

<h3>1. Git-flow</h3>

![image](https://github.com/JustBasicPro/Study/assets/38283489/8f141312-25c6-40df-bbbc-6e0ea30e1d23)

+ Master

  실제로 서비스에 배포되는 브랜치이다.

+ Develop

  새 버전에 대한 개발을 진행하는 브랜치이다.

+ Feature

  개발의 기본 단위인 기능을 추가하기 위한 브랜치이다.
  
  (Develop에서 시작되어 Develop으로 합쳐진다.)

+ Release

  Develop에서 새 버전에 대한 개발이 마무리되어 출시하기 위한 브랜치이다.

  (Develop에서 시작되어 Master와 Develop으로 합쳐진다.)

+ Hotfix

  Master에서 생긴 버그를 급하게 해결하기 위한 브랜치이다.

  (Master에서 시작되어 Master와 Develop으로 합쳐진다.)


Master, Develop 브랜치는 실제로 배포하거나 개발자들이 공유하기 위해 보존되어야 하는 브랜치이다. 하지만 Feature, Release, Hotfix 브랜치는 Develop 또는 Master 브랜치를 업데이트하기 위한 수단입니다.

<br>

<h3>2. Github-flow</h3>

![image](https://github.com/JustBasicPro/Study/assets/38283489/3a441422-d2de-4c3d-95f2-f4d0b48e626d)

+ Master

  실제로 서비스에 배포되는 브랜치이다.

+ Feature

  개발의 기본 단위인 기능을 추가하기 위한 브랜치이다.
  (새로운 기능은 feature에 작업하여 master로 병합합니다.)

Github Flow는 브랜치 수가 적기 때문에 빠르게 작업이 가능하며 원본 브랜치에 병합하여 쉽게 배포할 수 있는 장점이 있습니다.

<br><br>

출처 : [https://blog.git-init.com/immutable-snapshot-in-git/], [https://goo-gy.github.io/2022-07-24-git-flow]
