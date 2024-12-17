# ktor-discriminator-sample

How to reproduce the issue:

1. Start the project
2. Send curl request: `curl -H "content-type: application/json" -X POST http://localhost:8080/some -v -d '{"state":{"type":"a","status":"a"}}'`

