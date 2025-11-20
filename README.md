# Kotlin Validator - Ktor Example

A working example demonstrating the **[kotlin-validator](https://github.com/noovoweb/kotlin-validator)** library with **Ktor**.

## 📚 Full Documentation

**For complete documentation, setup guides, and all features, see:**

👉 **[kotlin-validator Library README](https://github.com/noovoweb/kotlin-validator)**

The library README includes:
- Complete setup instructions
- All validation annotations
- Custom validator creation
- Advanced usage (I/O operations, dispatchers)
- Internationalization (i18n)
- Ktor integration guide
- Performance optimization

## 🚀 Quick Start

### Prerequisites
- Java 21+
- Gradle

### Run the Application

```bash
./gradlew run
```

Application starts at: `http://localhost:8082`

### Test the API

#### Using cURL

```bash
# Test email validation
curl -X POST http://localhost:8082/ktor/api/string/email \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com"}'

# Test with French locale
curl -X POST http://localhost:8082/ktor/api/string/email \
  -H "Content-Type: application/json" \
  -H "Accept-Language: fr" \
  -d '{"email":"invalid"}'
```

#### Using Postman

Import the included collection:
- **File:** `Kotlin Validator Ktor API.postman_collection.json`
- **Base URL:** `http://localhost:8082`

The collection includes comprehensive test requests for all validators.

## ✨ What's Included

This example demonstrates:

✅ **Built-in validators** organized by category:
- String validation (@Email, @Url, @Pattern, etc.)
- Numeric validation (@Min, @Max, @Between, etc.)
- Date/Time validation (@Future, @Past, @Today, etc.)
- Collection validation (@Size, @Distinct, @NotEmpty, etc.)
- File validation (@MimeType, @FileExtension, etc.)
- Network validation (@IPv4, @IPv6, @MacAddress, etc.)
- Conditional validation (@Same, @RequiredIf, etc.)

✅ **Custom validators** (password strength)

✅ **Internationalization** (English/French via Accept-Language header)

✅ **Nested validation** with @Valid annotation

✅ **Automatic error handling** (422 status codes)

✅ **Native coroutine patterns** with Ktor

**API Base Path:** `/ktor/api/*`

## 💡 Usage Example

```kotlin
// 1. Define request with validators
@Validated
data class RegisterRequest(
    @Required @Email
    val email: String?,
    
    @Required @StrongPassword
    val password: String?
)

// 2. Use in Ktor route
fun Route.registerRoute(validationContext: ValidationContext) {
    post("/register") {
        val payload = call.receive<RegisterRequest>()
        
        // Validates with i18n support
        RegisterRequestValidator().validate(payload, validationContext)
        
        call.respond(HttpStatusCode.OK, payload)
    }
}
```

**Validation Error Response:**
```json
{
  "status": 422,
  "error": "Validation Failed",
  "errors": {
    "email": ["Please enter a valid email address"],
    "password": ["Password must be at least 12 characters..."]
  }
}
```

## 🌍 Internationalization

Test with different locales using the `Accept-Language` header:

```bash
# English (default)
curl -X POST http://localhost:8082/ktor/api/scenario/register \
  -H "Content-Type: application/json" \
  -d '{"email":"invalid"}'

# French
curl -X POST http://localhost:8082/ktor/api/scenario/register \
  -H "Content-Type: application/json" \
  -H "Accept-Language: fr" \
  -d '{"email":"invalid"}'
```

## 🔧 Dependencies

```kotlin
dependencies {
    implementation("com.noovoweb:kotlin-validator-annotations:0.1.1")
    implementation("com.noovoweb:kotlin-validator-runtime:0.1.1")
    ksp("com.noovoweb:kotlin-validator-ksp:0.1.1")
}
```

## 📖 Learn More

For detailed documentation on:
- Setting up the library
- Creating custom validators
- Advanced usage patterns
- Performance tuning
- All validator options

**Visit:** 👉 **[kotlin-validator Library README](https://github.com/noovoweb/kotlin-validator)**

## 📝 License

This example project is provided as-is for demonstration purposes.
