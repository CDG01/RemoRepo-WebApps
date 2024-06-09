# Consegna:

write a Spring Boot application with the necessary dependencies that:
- has 2 controllers:
  1. BasicController that:
     - is mapped on time
     - returns the current date/time
  2. LegacyController that:
     - is mapped on legacy
     - returns This is just old code
- has 2 interceptors/middleware:
  1. APILoggingInterceptor that prints in the console the requests header User-Agent, before handling them
  2. LegacyIntercepotr that:
     - blocks the API calls to the legacy endpoint
     - returns a response with the right HTTP code status for Gone
     
test the 2 API endpoint calls using Postman