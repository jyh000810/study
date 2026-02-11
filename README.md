
```mermaid
flowchart TD
    User([사용자 입력]) --> Router{LLM Router}

    %% ------------------------------------------------
    %% 1. 기타 기능 (단발성)
    %% ------------------------------------------------
    Router -- "GUIDE (가이드)" --> GuideRes[가이드 답변 제공]
    Router -- "OTHER (기타)" --> OtherRes[일상 응대]

    %% ------------------------------------------------
    %% 2. 데이터 수집 단계 (NEW / AGAIN)
    %% ------------------------------------------------
    Router -- "AGAIN (재발행)" --> LoadHistory[이전 이력 조회] --> PushSlots
    Router -- "NEW (신규)" --> QdrantSearch{1. Qdrant 검색}

    %% Qdrant 검색 결과 분기
    QdrantSearch -- "확실 (Score >= 0.8)" --> FoundData[데이터 확보] --> PushSlots
    QdrantSearch -- "모호 (0.6 ~ 0.8)" --> ShowOptions[유사 업체/품목<br/>옵션 버튼 제공]
    QdrantSearch -- "없음 (Score < 0.6)" --> EmptyData[빈 슬롯 상태] --> PushSlots

    %% 사용자 선택 (옵션에서 선택 시)
    ShowOptions -.-> UserSelect([사용자 선택]) --> Router
    UserSelect -- "EDIT (선택값 입력)" --> PushSlots(데이터 Context 병합)

    %% ------------------------------------------------
    %% 3. 핵심: EDIT 프로세스 (무조건 여기를 통과함)
    %% ------------------------------------------------
    Router -- "EDIT (수정/입력)" --> PushSlots
    
    subgraph EDIT_PROCESS [CORE: 데이터 완성 및 발행]
        PushSlots --> CheckMissing{필수값 누락 확인}
        
        CheckMissing -- "누락 있음" --> AskUser[부족한 정보 질문<br/>(거래처/품목/금액/날짜)]
        AskUser --> User
        
        CheckMissing -- "완벽함" --> FinalConfirm{최종 발행 확인}
        FinalConfirm -- "User: 예" --> IssueDone((발행 완료))
        FinalConfirm -- "User: 아니오" --> AskUser
    end

    %% 스타일 정의
    style EDIT_PROCESS fill:#e3f2fd,stroke:#1565c0,stroke-width:2px,rx:10,ry:10
    style PushSlots fill:#2196f3,color:#fff,stroke:#333
    style IssueDone fill:#00c853,color:#fff,stroke:#333
    style QdrantSearch fill:#ffecb3,stroke:#333
```
