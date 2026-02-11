flowchart TD
    User([사용자 입력]) --> Router{LLM Router}

    %% 1. INVOICE PROCESS
    Router -- "INVOICE" --> InvoiceType{발행 유형}
    
    InvoiceType -- "NEW (신규)" --> PartnerCheck[1. 거래처 식별\n(Qdrant Vector Search)]
    
    PartnerCheck -- "Score >= 0.8" --> PartnerFound[데이터 자동 반환]
    PartnerCheck -- "0.6 <= Score < 0.8" --> PartnerSelect[유사 업체 옵션 제공]
    PartnerCheck -- "Score < 0.6" --> PartnerInput[거래처 입력 요청]

    PartnerFound --> ItemCheck[2. 품목/금액 검증]
    PartnerSelect --> ItemCheck
    PartnerInput --> ItemCheck

    ItemCheck -- "품목 누락" --> MatchAmount[금액 일치 데이터\n옵션 제공 (Max 5)]
    ItemCheck -- "금액 누락" --> MatchItem[품목 유사도 >= 0.7\n옵션 제공]
    ItemCheck -- "둘 다 누락" --> MatchRecent[최근 거래 기반\n옵션 제공]
    ItemCheck -- "데이터 완비" --> FinalConfirm[최종 발행 확인]

    InvoiceType -- "EDIT (수정)" --> SlotFilling[부족한 정보 입력/수정] --> FinalConfirm

    %% 2. OTHER PROCESSES
    Router -- "AGAIN (재발행)" --> FetchHistory[이전 발행 이력 조회] --> FinalConfirm
    Router -- "GUIDE (가이드)" --> ShowGuide[가이드 답변 제공\n+ 발행 유도]
    Router -- "OTHER (기타)" --> ChitChat[일상 응대\n+ 발행 유도]

    %% Style
    style Router fill:#f9f,stroke:#333,stroke-width:2px
    style PartnerCheck fill:#bbf,stroke:#333
    style ItemCheck fill:#bbf,stroke:#333
    style FinalConfirm fill:#9f9,stroke:#333,stroke-width:2px
