# Project Standards — SKIT-CSE-2023-2027-05

Status: scaffolding phase. No business logic exists yet — this document
records the infra/tooling decisions the scaffold is built on, so anyone
(human or agent) picking up the repo later knows why it looks the way it
does.

## Repository layout

```
.
├── backend/                 # Spring Boot API
├── frontend/                # React + TypeScript app
├── docs/                    # Project documentation (this directory)
├── .github/
│   └── workflows/
│       ├── backend-ci.yml
│       └── frontend-ci.yml
├── .gitignore
└── README.md
```

## Backend (`backend/`)

- **Framework**: Spring Boot, Maven build
- **Java version**: 25 (current LTS)
- **Coordinates**: `groupId` = `com.kronos`, `artifactId` = `com.kronos`
- **Persistence**: Spring Data JPA + PostgreSQL
- **Schema management**: Hibernate `ddl-auto` for now. A migration tool
  (Flyway or Liquibase) should be introduced before the schema is
  considered stable — tracked as an open item below.
- **Local env vars**: loaded from `backend/.env` via `spring-dotenv`
  (Spring Boot does not read `.env` files natively). `backend/.env.example`
  documents the required variables.
- **Local database**: no Docker — PostgreSQL runs natively on the
  developer's machine. Connection details go through `.env`.

## Frontend (`frontend/`)

- **Scaffold**: `npm create vite@latest` — `react-ts` template (includes
  ESLint)
- **Package manager**: npm
- **Node.js version**: 24 (Active LTS)
- **Env vars**: Vite's native `.env` loading — `frontend/.env.example`
  documents the required variables.

## CI (GitHub Actions)

- Two independent workflows: `backend-ci.yml` and `frontend-ci.yml`.
- Trigger: pull requests targeting `main`, path-filtered so a
  frontend-only change doesn't run the backend job and vice versa.
- Scope for now: build + test only. No deploy job — deployment target
  and hosting are undecided.

## Local development

No Docker Compose or containers for local dev at this stage — backend,
frontend, and PostgreSQL all run natively on the developer's machine.
This was a deliberate choice to keep the scaffold simple; it can be
revisited if the team grows or environment drift becomes a problem.

## Open items / to revisit

- Migration tool (Flyway vs Liquibase) once the schema stabilizes
- Deployment target and CD pipeline
- Whether Docker is worth reintroducing for local/dev parity
