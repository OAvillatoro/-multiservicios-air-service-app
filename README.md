# AirServiceApp

Aplicación Android desarrollada en Kotlin y Jetpack Compose para la administración de servicios de mantenimiento de aire acondicionado de la empresa **MultiServicios de Oriente**.

Este proyecto forma parte del proyecto final de la asignatura **Técnicas de Producción Industrial de Software I**, orientado al desarrollo de una aplicación móvil funcional basada en una necesidad real de una empresa.

## Descripción del proyecto

AirServiceApp permite gestionar de forma digital el proceso de mantenimiento de equipos de aire acondicionado. La aplicación está diseñada para facilitar el registro de clientes, equipos, solicitudes de mantenimiento, programación de técnicos, órdenes de trabajo, reportes finales e historial de servicios.

Actualmente el proyecto cuenta con un prototipo funcional con navegación entre pantallas y datos de prueba, representando los flujos principales del sistema.

## Empresa seleccionada

**MultiServicios de Oriente**

Empresa dedicada a servicios de instalación, mantenimiento y venta de aires acondicionados.

## Necesidad identificada

La empresa requiere una herramienta móvil que permita organizar y dar seguimiento a los servicios de mantenimiento de aire acondicionado, evitando depender únicamente de registros manuales, hojas de cálculo o comunicación informal.

La app busca centralizar:

* Registro de clientes.
* Registro de equipos.
* Solicitudes de mantenimiento.
* Programación de visitas técnicas.
* Asignación de técnicos.
* Seguimiento de órdenes de trabajo.
* Reportes finales del servicio.
* Historial de mantenimiento por equipo.

## Tecnologías utilizadas

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Navigation Compose
* Gradle Kotlin DSL
* Git
* GitHub

## Configuración del proyecto

* Nombre del proyecto: `AirServiceApp`
* Package name: `com.multiserviciosoriente.airserviceapp`
* Minimum SDK: API 26 Android 8.0
* Lenguaje: Kotlin
* UI: Jetpack Compose

## Roles contemplados

La aplicación contempla cuatro tipos principales de usuario:

### Cliente

Puede registrar sus equipos, solicitar mantenimiento, consultar el historial de sus equipos y actualizar su perfil.

### Administrador

Puede consultar el panel administrativo, revisar solicitudes, programar servicios, asignar técnicos y dar seguimiento a órdenes de trabajo.

### Encargado

Puede gestionar solicitudes, programar visitas, asignar técnicos y dar seguimiento operativo a los servicios.

### Técnico

Puede consultar órdenes asignadas, revisar detalles de los servicios y registrar el reporte final del mantenimiento realizado.

## Pantallas implementadas

El prototipo actual incluye las siguientes pantallas:

* Login
* Registro de cliente
* Home Cliente
* Mi Perfil Cliente
* Mis Equipos
* Formulario de Equipo
* Solicitud de Mantenimiento
* Historial del Equipo
* Home Administrador
* Home Encargado
* Home Técnico
* Bandeja de Solicitudes
* Programar y Asignar Técnico
* Detalle de Solicitud / Orden
* Órdenes de Trabajo
* Reporte Final del Técnico

## Navegación implementada

La navegación principal se encuentra organizada mediante:

* `AppRoutes.kt`
* `AppNavigation.kt`
* `MainActivity.kt`

El archivo `MainActivity.kt` carga la navegación principal de la aplicación usando `AppNavigation()`.

## Estructura de paquetes

El proyecto está organizado bajo la siguiente estructura base:

```text
com.multiserviciosoriente.airserviceapp
│
├── data
│   ├── local
│   └── repository
│
├── domain
│   ├── model
│   └── usecase
│
├── presentation
│   ├── components
│   ├── navigation
│   ├── screens
│   │   ├── admin
│   │   ├── auth
│   │   ├── equipment
│   │   ├── history
│   │   ├── home
│   │   ├── profile
│   │   ├── requests
│   │   └── workorders
│   └── viewmodel
│
└── utils
```

## Estado actual del proyecto

El proyecto actualmente cuenta con:

* Proyecto Android creado.
* Navegación entre pantallas implementada.
* Estructura de paquetes organizada.
* Pantallas principales del prototipo desarrolladas.
* Repositorio Git activo.
* Commits incrementales registrados.
* Capturas de la app ejecutándose en emulador.
* Flujos principales validados manualmente.

## Flujos validados

### Flujo Cliente

* Login.
* Registro de cliente.
* Home Cliente.
* Mi Perfil.
* Mis Equipos.
* Agregar equipo.
* Solicitar mantenimiento.
* Historial del equipo.

### Flujo Administrador

* Home Admin.
* Bandeja de solicitudes.
* Ver detalle de solicitud.
* Programar y asignar técnico.
* Registrar reporte final.

### Flujo Encargado

* Home Encargado.
* Bandeja de solicitudes.
* Programación de servicios.
* Asignación de técnico.
* Seguimiento de solicitudes.

### Flujo Técnico

* Home Técnico.
* Órdenes de trabajo.
* Detalle de orden.
* Reporte final del servicio.

## Base de datos

Se diseñó una base de datos local en SQLite para representar las entidades principales del sistema.

Tablas consideradas:

* roles
* users
* equipment_types
* equipments
* request_statuses
* maintenance_requests
* work_orders
* reschedules
* service_events
* service_reports
* notifications
* sync_queue

Actualmente la app utiliza datos de prueba para validar el prototipo visual y la navegación. La integración completa con Room queda como siguiente fase del desarrollo.

## Próximas mejoras

* Integrar Room como base de datos local.
* Crear entidades, DAO y AppDatabase.
* Conectar repositorios y ViewModels.
* Implementar CRUD real de clientes, equipos y solicitudes.
* Guardar reportes finales del técnico.
* Consultar historial real de mantenimiento.
* Implementar autenticación local.
* Mejorar validaciones de formularios.
* Agregar persistencia de sesión.

## Repositorio

Repositorio del proyecto:

```text
https://github.com/OAvillatoro/-multiservicios-air-service-app
```

## Autor

Oscar Villatoro

Proyecto desarrollado para la asignatura:

**Técnicas de Producción Industrial de Software I**
