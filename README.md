
# Spring Boot Login Log – Technical Test (Amaris)

Este repositorio contiene una API desarrollada con **Spring Boot** como parte de una prueba técnica para registrar eventos de inicio de sesión de usuarios. El sistema se integra con una API externa (DummyJSON) para validar credenciales y, si la autenticación es exitosa, guarda el evento en una base de datos **PostgreSQL**.

## 🛠️ Arquitectura y Diseño

El proyecto fue desarrollado aplicando una **arquitectura limpia**, garantizando una clara **separación de responsabilidades**, lo cual permite alta cohesión, bajo acoplamiento y una mejor **escalabilidad**. Además, se implementaron principios SOLID para asegurar un diseño sostenible y extensible.

---

## 🧱 Principios SOLID implementados

### 1. **Single Responsibility Principle (SRP)**

Cada clase del proyecto tiene una única responsabilidad:

* `LoginLogController.java`: gestiona las solicitudes HTTP.
* `LoginLogServiceImpl.java`: contiene la lógica de negocio.
* `LoginLogRepository.java`: interacción con la base de datos.
* `LoginLogMapper.java`: convierte entre entidades y DTOs.
* `LoginLogDto.java`: define el objeto de transferencia de datos.

---

### 2. **Open/Closed Principle (OCP)**

El servicio fue diseñado utilizando una interfaz (`LoginLogService`) y su implementación (`LoginLogServiceImpl`), permitiendo la extensión del comportamiento sin modificar la estructura existente.

---

### 3. **Liskov Substitution Principle (LSP)**

El principio se respeta asegurando que cualquier implementación concreta (como `LoginLogServiceImpl`) puede ser usada donde se espera la interfaz `LoginLogService`, sin alterar la funcionalidad del sistema.

---

## ✅ Testing

Se implementaron pruebas unitarias para verificar el correcto funcionamiento del servicio `LoginLogService`, validando la inserción de registros en la base de datos.

---

## ⚠️ Manejo de dependencias

Durante el desarrollo se presentó un conflicto de dependencias al intentar integrar Feign Client para conectarse con la API externa. Como alternativa, y por motivos de tiempo, se optó por desarrollar un **cliente frontend sencillo en HTML + JavaScript** que autentica contra la API de DummyJSON y, tras un login exitoso, registra la información en la tabla `login_log` a través del endpoint local.

---

## 💻 Frontend simple para pruebas

Se desarrolló una interfaz de prueba básica que simula un formulario de login, puede usarlo facilmente con vscode/liveserver extension

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Login Log</title>
  </head>
  <body>
    <h1>Login Log</h1>
    <form id="loginForm">
      <label>Username: <input type="text" id="username" required /></label><br /><br />
      <label>Password: <input type="password" id="password" required /></label><br /><br />
      <button type="submit">Submit</button>
    </form>

    <pre id="response"></pre>

    <script>
      const form = document.getElementById("loginForm");
      const responseBox = document.getElementById("response");

      form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try {
          const dummyResponse = await fetch("https://dummyjson.com/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password }),
          });

          if (!dummyResponse.ok) throw new Error("Authentication with DummyJSON failed.");
          const dummyData = await dummyResponse.json();

          const backendResponse = await fetch("http://localhost:8080/api/loginLog", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
              userName: username,
              loginTime: new Date().toISOString(),
              refreshToken: dummyData.refreshToken,
              accessToken: dummyData.accessToken,
            }),
          });

          if (!backendResponse.ok) throw new Error(`Backend failed. Status: ${backendResponse.status}`);
          const backendData = await backendResponse.json();
          responseBox.textContent = "Login log created:\n" + JSON.stringify(backendData, null, 2);
        } catch (error) {
          responseBox.textContent = "Error: " + error.message;
        }
      });
    </script>
  </body>
</html>
```

---

## 📹 Demo en video

A continuación, se encuentra un video de demostración que muestra el funcionamiento de la prueba técnica:
🔗 \ https://youtu.be/WsJRLmgZ6xw

---

## 🧾 Tecnologías utilizadas

* Java 21
* Spring Boot 3.x
* PostgreSQL
* Maven
* HTML + JavaScript (Frontend simple)
* DummyJSON API (para autenticación simulada)

---

## 🚀 Cómo ejecutar

1. Clonar el repositorio
2. Configurar la conexión a la base de datos PostgreSQL en `application.yml`
3. un usuario de prueba puede ser: user: emilys , pass: emilyspass
4. Ejecutar el proyecto con:

```bash
mvn spring-boot:run
```

4. Abrir el archivo HTML en el navegador para realizar pruebas

