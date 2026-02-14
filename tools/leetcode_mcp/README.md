# LeetCode MCP (Minimal)

A minimal stdio MCP server for daily LeetCode metadata queries.

## Tools

- `get_global_problem(frontend_id)`
  - Source: `https://leetcode.com/graphql`
  - Input examples: `"4"`, `"LeetCode0004"`
- `get_lcr_problem(lcr_id)`
  - Source: `https://leetcode.cn/graphql/`
  - Input examples: `"180"`, `"LCR 180"`
- `to_javadoc_description(content, mode)`
  - Converts HTML content (`content` or `translatedContent`) into JavaDoc-ready lines.
  - `mode`:
    - `normalized` (default): trims example/constraint sections
    - `literal`: keeps all lines after HTML stripping

## Return Shape (problem tools)

- `source`
- `frontend_id`
- `title`
- `translated_title` (LCR only)
- `slug`
- `difficulty`
- `url`
- `content_html`
- `description_lines`
- `javadoc_lines`
- `fetched_at`

## Cache

- Default: `~/.cache/leetcode-mcp/cache.json`
- Override with env var: `LEETCODE_MCP_CACHE_PATH`

## Run

```bash
python tools/leetcode_mcp/server.py
```

## MCP Client Config (example)

```json
{
  "mcpServers": {
    "leetcode": {
      "command": "python",
      "args": ["/Users/jenslewie/github/jenslewie-algo-pathfinder/tools/leetcode_mcp/server.py"]
    }
  }
}
```

## Notes

- The server is dependency-free (Python standard library only).
- Network access is required for live queries.
