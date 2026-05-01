# 📋 AppTareas

Aplicación móvil nativa para la gestión de tareas desarrollada en Android Studio utilizando Kotlin y tecnologías modernas del ecosistema Android como Jetpack Compose, MVVM, ROOM, Hilt, Coroutines y Flow.
El proyecto fue desarrollado con el objetivo de fortalecer conocimientos en arquitectura moderna Android, manejo de persistencia local y desarrollo de interfaces declarativas con Compose.

---

# 🚀 Características

- ✅ Crear tareas
- ✅ Editar tareas
- ✅ Eliminar tareas
- ✅ Visualizar lista de tareas
- ✅ Persistencia local con ROOM Database
- ✅ Configuración persistente mediante DataStore Preferences
- ✅ Arquitectura MVVM
- ✅ Inyección de dependencias con Hilt
- ✅ Programación asíncrona con Coroutines
- ✅ Actualización reactiva de datos con Flow
- ✅ Interfaz moderna desarrollada con Jetpack Compose

---

# 🏗️ Arquitectura

El proyecto implementa el patrón de arquitectura MVVM (Model - View - ViewModel) para mantener una separación clara de responsabilidades y facilitar la escalabilidad y mantenibilidad del código.

## 📂 Estructura del proyecto

```bash
com.example.apptareas
│
├── data
│   ├── local
│   │   ├── dao
│   │   ├── database
│   │   └── entity
│   │
│   └── repository
│
├── di
│
├── navigation
│
├── ui
│   ├── components
│   ├── screens
│   ├── theme
│   └── viewmodel
│
└── utils
```

---

# 🛠️ Tecnologías utilizadas

| Tecnología | Descripción |
|---|---|
| Kotlin | Lenguaje principal de desarrollo |
| Jetpack Compose | Desarrollo de interfaces declarativas |
| MVVM | Arquitectura de la aplicación |
| ROOM Database | Persistencia local de datos |
| Hilt | Inyección de dependencias |
| Coroutines | Programación asíncrona |
| Flow | Manejo reactivo de datos |
| DataStore Preferences | Persistencia de configuraciones |
| Navigation Compose | Navegación entre pantallas |

---

# 📱 Funcionalidades principales

## 📌 Gestión de tareas
- Creación de nuevas tareas
- Edición de tareas existentes
- Eliminación de tareas
- Visualización dinámica de tareas

## 💾 Persistencia local
- Almacenamiento local utilizando ROOM Database
- Persistencia de configuraciones mediante DataStore Preferences

## ⚡ Arquitectura moderna
- Implementación del patrón MVVM
- Uso de ViewModel para manejo de estados
- Actualización reactiva utilizando Kotlin Flow

## 🎨 Interfaz de usuario
- UI declarativa desarrollada completamente con Jetpack Compose
- Componentes reutilizables
- Navegación entre pantallas con Navigation Compose

---

# ⚙️ Instalación y ejecución

## 📋 Requisitos

- Android Studio Hedgehog o superior
- JDK 17
- SDK Android actualizado

---

## 📥 Clonar el repositorio

```bash
git clone https://github.com/seBas281201/AppTareas.git
```

---

## ▶️ Ejecutar el proyecto

1. Abrir Android Studio
2. Seleccionar la opción **Open**
3. Elegir la carpeta del proyecto
4. Esperar sincronización de Gradle
5. Ejecutar la aplicación en un emulador o dispositivo físico

---

# 🧠 Conceptos aplicados

Durante el desarrollo del proyecto se aplicaron conceptos importantes de desarrollo Android moderno:

- Arquitectura MVVM
- Manejo de estados en Compose
- Persistencia local con ROOM
- Inyección de dependencias con Hilt
- Programación asíncrona con Coroutines
- Programación reactiva con Flow
- Separación de responsabilidades
- Buenas prácticas de organización de código
- Navegación entre pantallas
- Componentes reutilizables

---

# 📚 Objetivo del proyecto

Este proyecto fue desarrollado como práctica de aprendizaje para fortalecer habilidades en desarrollo Android nativo moderno y construir un portafolio orientado a oportunidades laborales como Android Developer Junior.

---

# 📈 Posibles mejoras futuras

- Implementación de Clean Architecture
- Soporte para autenticación de usuarios
- Sincronización con Firebase
- Implementación de pruebas unitarias
- Modo offline avanzado
- Notificaciones y recordatorios
- Filtros y búsqueda de tareas

---

# 👨‍💻 Autor

Sebastián Gonzalez

## 🔗 Contacto

- GitHub: https://github.com/seBas281201

---

# 📄 Licencia

Este proyecto fue desarrollado con fines educativos y de portafolio personal.
