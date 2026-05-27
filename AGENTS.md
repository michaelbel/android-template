# Repository Guidelines

## Git
- Never commit unrelated files together – stage files selectively and make one focused commit per logical change with a clear, specific message
- When the user asks to make a commit, the main task is to choose an appropriate commit message and commit all currently changed files, using one or several focused commits when needed; do not leave files in a modified state. If the user changed or removed something themselves, commit only the current working tree state and do not restore changes from your context.
- For dependency updates, commit each dependency separately with message format: `Bump <dependency> from <old version> to <new version>`
