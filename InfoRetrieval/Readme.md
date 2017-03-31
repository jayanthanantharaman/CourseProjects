Information retrieval (IR) system using Lucene API’s.

Approach:
Developed an IR system for document retrieval using Cranfield/Medline datasets.
The systems is built using Spring Boot framework on top of Lucene.  
There are 2 REST services which serves the purpose of Indexing and searching.


To create Index:
GET:
http://localhost:9999/inforetrieval/api/retrievedocs/buildIndex


To Search for Queries:
POST:
http://localhost:9999/inforetrieval/api/retrievedocs
Query as payload:

