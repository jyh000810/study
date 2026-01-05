```mermaid
sequenceDiagram
    participant User as 사용자
    participant App as 애플리케이션
    participant VectorDB as 벡터 DB (지식저장소)
    participant LLM as Gemini/GPT

    User->>App: 질문 입력 ("내 문서 내용 요약해줘")
    App->>VectorDB: 질문과 관련된 문서 검색 (Query Embedding)
    VectorDB-->>App: 관련 문서 청크(Chunk) 반환
    App->>LLM: 프롬프트 전송 (질문 + 관련 문서 내용)
    LLM-->>App: 문서를 바탕으로 답변 생성
    App->>User: 최종 답변 출력
