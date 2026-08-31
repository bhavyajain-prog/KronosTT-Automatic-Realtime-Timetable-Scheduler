# Git Workflow — SKIT-CSE-2023-2027-05

## Branching model

- `main` is the only long-lived branch.
- All work happens on feature branches, branched from the latest `main`:
  `feat/<short-feature-name>` (e.g. `feat/backend-scaffold`,
  `feat/user-auth`).
- No `dev` branch. This was a deliberate simplification for a
  small college-project team with no separate staging environment —
  every change goes straight to a PR against `main`. Revisit if the
  team or deployment setup grows enough to justify a staging branch.

## Branch protection (`main`)

- No direct pushes to `main`.
- Merging requires an open pull request.
- Required CI checks (`backend-ci.yml` and/or `frontend-ci.yml`,
  whichever apply based on changed paths) must pass before a PR can
  merge.
  - Note: branch protection rules are configured in the GitHub repo
    settings UI, not via any file in this repo — set this up once the
    repo exists on GitHub.

## Pull requests

- Every change lands via PR: `feat/<name>` → `main`.
- Keep each PR scoped to one feature or fix — avoid bundling unrelated
  backend and frontend changes in the same PR where avoidable.

## Commit messages

- Convention: [Conventional Commits](https://www.conventionalcommits.org/) —
  `type(scope): summary`, e.g. `feat(backend): add user entity`,
  `chore(repo): scaffold monorepo structure`.
- Common types: `feat`, `fix`, `chore`, `docs`, `ci`, `refactor`, `test`.
- (This convention wasn't explicitly discussed before scaffolding started —
  treat it as a default and adjust if the team prefers something else.)

## CI triggers

- `backend-ci.yml` and `frontend-ci.yml` both trigger on pull requests
  targeting `main`.
- Each workflow is path-filtered to its own app directory
  (`backend/**` / `frontend/**`), so unrelated changes don't trigger an
  unnecessary run.
