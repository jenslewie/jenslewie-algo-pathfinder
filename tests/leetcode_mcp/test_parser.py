import unittest

from tools.leetcode_mcp.server import html_to_lines, to_javadoc_lines


class ParserTests(unittest.TestCase):
    def test_html_to_lines_normalized_stops_before_examples(self):
        raw = (
            "<p>Line 1.</p>"
            "<p>Line 2.</p>"
            "<p><strong>Example 1:</strong></p>"
            "<pre>Input: x</pre>"
        )
        self.assertEqual(html_to_lines(raw, mode="normalized"), ["Line 1.", "Line 2."])

    def test_html_to_lines_literal_keeps_examples(self):
        raw = (
            "<p>Line 1.</p>"
            "<p><strong>示例 1：</strong></p>"
            "<pre>输入：x</pre>"
        )
        self.assertEqual(html_to_lines(raw, mode="literal"), ["Line 1.", "示例 1：", "输入：x"])

    def test_to_javadoc_lines_appends_br_except_last(self):
        lines = ["a", "b", "c"]
        self.assertEqual(
            to_javadoc_lines(lines),
            ["* a <br>", "* b <br>", "* c"],
        )


if __name__ == "__main__":
    unittest.main()
