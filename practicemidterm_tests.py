#!/usr/bin/python3
import unittest
import practicemidterm_funcs

class TestPracticeMidterm(unittest.TestCase):

 
# --------------------------------------------------------------
# Q1 TESTS
# --------------------------------------------------------------

    def test_rock_paper_scissors_01(self):
        self.assertEqual(practicemidterm_funcs.rock_paper_scissors("rock"),"paper")
        
    def test_rock_paper_scissors_02(self):
        self.assertEqual(practicemidterm_funcs.rock_paper_scissors("paper"),"scissors")

 
# --------------------------------------------------------------
# Q2 TESTS
# --------------------------------------------------------------

    def test_digit_sum_01(self):
        self.assertEqual(practicemidterm_funcs.digit_sum(123, 321), 10)
        
    def test_digit_sum_02(self):
        self.assertEqual(practicemidterm_funcs.digit_sum(0, 0), 0)

 
# --------------------------------------------------------------
# Q3 TESTS
# --------------------------------------------------------------

    def test_staircase_blocks_01(self):
        self.assertEqual(practicemidterm_funcs.staircase_blocks(4, 3), 20)

    def test_staircase_blocks_02(self):
        self.assertEqual(practicemidterm_funcs.staircase_blocks(1, 1), 1)

    def test_staircase_blocks_03(self):
        self.assertEqual(practicemidterm_funcs.staircase_blocks(5, 2), 14)

# --------------------------------------------------------------
# Q4 TESTS
# --------------------------------------------------------------

        
    def test_count_divisible_pairs_01(self):
        self.assertEqual(practicemidterm_funcs.count_divisible_pairs([12, 3, 8, 4, 6]), 4)

    def test_count_divisible_pairs_02(self):
        self.assertEqual(practicemidterm_funcs.count_divisible_pairs([10, 2, 5, 0, 20]), 3)

    def test_count_divisible_pairs_03(self):
        self.assertEqual(practicemidterm_funcs.count_divisible_pairs([7, 11, 13]), 0)

# --------------------------------------------------------------
# Q5 TESTS
# --------------------------------------------------------------
        
    def test_remduplicate_01(self):
        self.assertEqual(practicemidterm_funcs.remduplicate('moody'), 'mody')

    def test_remduplicate_02(self):
        self.assertEqual(practicemidterm_funcs.remduplicate('zoomzoomeeraaanng'), 'zomzomerang')

    def test_remduplicate_03(self):
        self.assertEqual(practicemidterm_funcs.remduplicate('aabbccddee'), 'abcde')
        
if __name__ == '__main__':
    unittest.main(exit=True)  