import unittest
def transmogrify_string(string_to_transmogrify):
    '''
    hewwo, I am chwis cwinge-l
    4ND 1 4M 4MR-B0T

    and today, we'we going to teach youwu
    4B0UT 5TR1NG C0MPR3H3N510N.

    we both speak with a uwuniquwue diawect
    4ND R3QU1R3 7R4N5L4710N 70 C0NV3R53 W17H Y0U

    uwuntiw youwu sowve this quwuestion
    W3 MU57 5P34K 1N 7H3S3 V01C35.

    Just kidding. Your task is as follows:
    Given an input string, return the transmogrified form of the string, such that the first half
    is uwuified, and the second half is translated into L337 speak.

    To uwuify a string, you must make it all lowercase, turn all "r"s and "l"s into "w"s, and turn all "u"s into "uwu"s
    To translate a string into L337 speak, you must make it all uppercase, turn "A"s into "4"s, "E"s into "3"s, 
        "I"s into "1"s, "O"s into "0"s, "S"s into "5"s, and "T"s into "7"s.
        
    If you reach the end of the first half of the string in the middle of a word, finish it in uwu-form.

    '''
    pass
    
def num_eat_num(current_num_list, num_iters, passable_data=None):
    '''
    Why was 6 afraid of 7? 

    Because 7 8 9! Get it?! Seven 'ate' nine!

    ...

    Well here's the thing: it's a number-eat-number world out there. Survival of the fittest, and all that.

    You're a number-ologist grad student, studying lists of numbers in their natural habitats. 
    You've stumbled upon a miraculous discovery: if a number is exactly 2 less than its neighbour,
    then the smaller one can eat its bigger neighbour! (e.g. 7 eats 9, or 3 eats 5)

    You want to publish this ASAP. Your supervisor tasks you with simulating a number-eat-number environment, using the following rules:
        
    You are given a list of unique numbers as input. 
    Start from the very left of the list in your processing.
    Look at the leftmost number L, and the number directly to its right R.

    If R is greater than L, then R will 'eat' L, UNLESS R is exactly 2 units greater than L, in which case L 'eats' R.
    So for example, [1, 2], or [1, 5] would have 2 or 5 'eat' 1, but [1, 3], or [6, 8], would have 1 'eat' 3, or 6 'eat' 8.
    Vice versa applies for R eating L, so for example [4, 2], would have 2 'eat' 4.

    When a number eats another number, it removes it from the list, but crucially, per your discovery, it also gains
    its 2-unit-greater-edible powers! (Much like the chimera ants in HunterXHunter (peak show don't @ me)).
                                                                            
    So for example, with [1, 3, 5], after one iteration you would have [1, 5] (as 1 eats 3), and after the second you would have
    just [1], (as 1 eats 5, by the powers it got from eating 3).

    But, if you had [1, 3, 4] then after one iteration you get [1, 4] (as 1 eats 3), and after the second you would have
    just [4], (as 4 eats 1).

    Finally, this property is inheritible in its totality. When one number eats another it gains all of its accumulated powers. 
    For example, with [1, 3, 4, 5], you would get [1(3), 4, 5] (where (3) indicates 1 has the 2-greater-eating-power of 3)
    [4 (1, 3), 5]
    [4 (1, 3, 5)]

    In the case of a situation where both numbers can eat eachother
    E.g. [1, 3, 5, 9, 7] -> [1(3), 5, 9, 7] -> [1(3,5), 9, 7] -> [9(1,3,5), 7]
    The leftmost number wins -> [9(1,3,5,7)]

    Given the list, as well as the number of iterations to run (or -1, for until last num standing), simulate 
    this ecological numerical phenomenon!
    Return the final list after the specified number of iterations.
    Note that there is an optional passable_data argument to the function that you can use if you so desire.

    As a final wrench in the question, solve this problem using recursion!
    '''
    pass

def outside_of(a, b, epsilon):
    '''
    Write a function that returns True if a and b are
    a distance greater than epsilon away from one another. For example:

    outside_of(5, 6, 2) -> False
    outside_of(5, 7, 1.5) -> True
    '''
    pass

def even_addition(n) :
    '''
    Returns the sum of the even numbers from n to 4*n, inclusive
    even_addition(2) returns 20 since 2, 3, 4, 5, 6, 7, 8 -> 2 + 4 + 6 + 8 = 20
    Do NOT assume that this function recieves a positive number, but do assume
    that it recieves an integer.
    '''
    pass

def factorial(num):
    '''
    Write a recursive factorial function. Then, write FIVE
    test cases for the output. Two test cases should be edge
    cases.
    '''
    pass

def heron(x, epsilon) :
    '''
    Write a function which returns a guess, the approximate square root of x,
    such that abs(guess**2 - x) < epsilon using Heron's algorithm. Start with
    guess = x / 2 and improve guess to be (guess + x / guess) / 2
    '''
    pass

def recursive_palindrome(s) :
    '''
    Assume that s is a string. Check to see if s is a palindrome.
    If it is, return True. Else, return False. Recall that a
    palindrome is a string that is the same string if reversed.

    You must use RECURSION to solve the problem.

    For example, 
    recursive_palindrome('racecar') is True
    recursive_palindrome('blue') is False
    '''
    pass

def remove_letter(s, removable_letter) :
    '''
    Assume s is a string, and removable_letter is a letter.
    Write a function that returns a string obtained by
    removing any intances of removable_letter in the string.
    If the string doesn't have any instances of removable_letter,
    it simply returns the original string.

    Should return a ValueError if the values aren't typed correctly.

    remove_letter('blue', 'x') should return 'blue'
    remove_letter(529, 'a') should raise ValueError
    remove_letter('red', 'yz') should raise ValueError
    remove_letter('', 'z') should return ''
    remove_letter('x', 'z') should return 'x'
    remove_letter('zz', 'z') should return ''
    '''
    pass

def split_sentence(sentence) :
    '''
    Assume that sentence is a valid string. Write a function
    which returns a list of the most frequent words in the sentence,
    where words are obtained by sentence.split(). Each word is trimmed
    by removing trailing punctuation marks.

    For example, 
    split_sentence('Hey diddle diddle the cat and the fiddle, the cow jumped over the moon')
    should return ['the'] since 'the' is the most frequent word.
    split_sentence('red; blue!! blue red']
    should return ['red', 'blue'], where the items are in any order.
    '''
    pass

def sentence_splitter(sentence) :
    '''
    Assume that sentence is a valid string. Write a function
    which returns a list of all the words in sentence, where a
    word is a tokenseparated by white space. Then for each word,
    make it lowercase and remove any character that is not 
    alpha-numeric (a-z or 0-9).

    For example, 
    sentence_splitter('Red@Dragon....ca is great!')
    should return ['reddragonca', 'is', 'great']
    '''
    pass

def string_concat(s) :
    '''
    Assume s is a string. Write a function that returns
    a new string formed by concatenating i copies of each
    letter at position i. Recall, i is any given index in
    a string or list.

    Here is an example:

    string_concat('dog') returns 'ogg' since 0 of 'd' and 1
    of 'o' and 2 of 'g'.

    Then, write four tests for this function. At least ONE
    should be an edge case.
    '''
    pass

class TestUwuify(unittest.TestCase):
    
    def test_1_word_uwu(self):
        self.assertEqual(transmogrify_string("hello"), "hewwo")
        self.assertEqual(transmogrify_string("sorry"), "sowwy")
        self.assertEqual(transmogrify_string("cute"), "cuwute")
    def test_shakespeare(self):
        self.assertEqual(transmogrify_string("To be or not to be, that is the question"), "to be ow not to be, that 15 7H3 QU35710N") # mid is first t of 'that'
        self.assertEqual(transmogrify_string("To bee or not to bee, that is the question"), "to bee ow not to bee, 7H47 15 7H3 QU35710N") # mid is ,
    def test_true_peak_literature(self):
        self.assertEqual(transmogrify_string("Somebody once told me the world is gonna roll me; I ain't the sharpest tool in the shed"), # mid is 1st l of 'roll'
                         "somebody once towd me the wowwd is gonna woww M3; 1 41N'7 7H3 5H4RP357 700L 1N 7H3 5H3D")
    def test_uwuroboception(self):
        self.assertEqual(transmogrify_string("uwu! nuzzles your PC! H4H4H4 R0b075 RUL3"), 'uwuwuwu! nuwuzzwes youwuw pc! H4H4H4 R0B075 RUL3')
    def test_edge_cases(self):
        self.assertEqual(transmogrify_string(""), "")
        self.assertEqual(transmogrify_string("U"), "uwu")
    
class TestNumEatNum(unittest.TestCase):
    
    def test_empty(self): # Empty list should stay empty
        self.assertEqual(num_eat_num([], 0), [])
        self.assertEqual(num_eat_num([], -1), [])
        self.assertEqual(num_eat_num([], 2), [])
    
    def test_one_element(self): # 1 element should remain unchanged
        self.assertEqual(num_eat_num([1], 0), [1])
        self.assertEqual(num_eat_num([1], -1), [1])
        self.assertEqual(num_eat_num([1], 2), [1])
    
    def test_two_elements(self):
        self.assertEqual(num_eat_num([1, 2], 0), [1, 2]) # No iters -> unchanged
        self.assertEqual(num_eat_num([1, 2], -1), [2]) # 2 > 1
        self.assertEqual(num_eat_num([1, 2], 2), [2]) # 2 > 1
        self.assertEqual(num_eat_num([2, 1], -1), [2]) # 2 > 1
        
    def test_two_elements_greater_rule(self):
        self.assertEqual(num_eat_num([1, 3], 0), [1, 3]) # No iters -> unchanged
        self.assertEqual(num_eat_num([1, 3], -1), [1]) # 3-2 = 1
        self.assertEqual(num_eat_num([1, 3], 1), [1]) # 3-2 = 1
        self.assertEqual(num_eat_num([1, 3], 2), [1]) # 3-2 = 1
        self.assertEqual(num_eat_num([3, 1], -1), [1]) # 3-2 = 1
        
    def test_inheritance_property(self):
        self.assertEqual(num_eat_num([1, 3, 5], -1), [1]) # 1 eats then eats
        self.assertEqual(num_eat_num([1, 3, 5], 1), [1, 5]) # 1 eats
        
    def test_small_endnum(self):
        self.assertEqual(num_eat_num([1, 3, 5, 2], -1), [2]) # 1 eats then eats then eaten
        self.assertEqual(num_eat_num([1, 3, 5, 2], 2), [1, 2]) # 1 eats then eats
    
    def test_complex_cases(self):
        self.assertEqual(num_eat_num([1, 3, 5, 4, 2, 7], -1), [2]) # 2 can eat 7 as 5 inherited
        self.assertEqual(num_eat_num([1, 3, 6, 4, 2, 7], -1), [7]) # 2 can't eat 7 as no 5
        self.assertEqual(num_eat_num([1, 3, 5, 9, 7], -1), [9]) # left takes precedence
        self.assertEqual(num_eat_num([1, 3, 5, 7, 9], -1), [1])
        self.assertEqual(num_eat_num([9, 6, 5], -1), [9])
        self.assertEqual(num_eat_num([9, 6, 7], -1), [7])
        
class myTests(unittest.TestCase):
    
    def test0(self):
        self.assertEqual(outside_of(5, 6, 2), False)
    def test1(self):
        self.assertEqual(outside_of(5, 7, 1.5), True)
    def test2(self):
        self.assertEqual(outside_of(1, 2, 1), False)
    def test3(self):
        self.assertEqual(outside_of(9, 9, 0), False)
    def test4(self):
        self.assertEqual(outside_of(9, 9, 100), False)
    def test5(self):
        self.assertEqual(outside_of(-90, 100, 0), True)
        
class myTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(even_addition(2), 20)
    def test2(self):
        self.assertEqual(even_addition(1), 6)
    def test3(self):
        self.assertEqual(even_addition(0), 0)
    def test4(self):
        self.assertEqual(even_addition(100), 37750)
        
class FacTest(unittest.TestCase):
    def test1(self):
        self.assertEqual(factorial(0),1)
    def test2(self):
        self.assertEqual(factorial(1),1)
    def test3(self):
        self.assertEqual(factorial(5),120)
    def test4(self):
        self.assertEqual(factorial(8),40320)
    def test5(self):
        self.assertEqual(factorial(12),479001600)


class HeronTests(unittest.TestCase):
    def test1(self):
        self.assertAlmostEqual(heron(4, 0.0001), 2.0)
    def test2(self):
        self.assertAlmostEqual(heron(9, 0.0001), 3.0)
    def test3(self):
        self.assertAlmostEqual(heron(2, 0.000001), 1.414213)
    def test4(self):
        self.assertAlmostEqual(heron(0.25, 0.00001), 0.5)
    def test5(self):
        self.assertAlmostEqual(heron(100, 0.0001), 10.0)
    def test6(self):
        with self.assertRaises(ValueError): heron(-4, 0.0001)
        
class PalinTests(unittest.TestCase):
    def test1(self):
        self.assertTrue(recursive_palindrome('racecar'))
    def test2(self):
        self.assertFalse(recursive_palindrome('blue'))
    def test3(self):
        self.assertTrue(recursive_palindrome('madam'))
        
class RemoveTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(remove_letter('blue', 'x'), 'blue')
    def test2(self):
        with self.assertRaises(ValueError):
            remove_letter(529, 'a')
    def test3(self):
        with self.assertRaises(ValueError):
            remove_letter('red', 'xy')
    def test4(self):
        self.assertEqual(remove_letter('y', 'x'), 'y')
    def test5(self):
        self.assertEqual(remove_letter('', 'x'), '')
    def test6(self):
        self.assertEqual(remove_letter('z', 'z'), '')

class myTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(split_sentence('Hey diddle diddle the cat and the fiddle, the cow jumped over the moon'), ['the'])
    def test2(self):
        self.assertEqual(sorted(split_sentence('red; blue!! blue red')), ['blue', 'red'])
    def test3(self):
        self.assertEqual(sorted(split_sentence('cat dog cat dog mouse')), ['cat', 'dog'])
    def test4(self):
        self.assertEqual(split_sentence('Hello! Hello, world? "Hello" again;'), ['hello'])
    def test5(self):
        self.assertEqual(split_sentence(''), [])
    def test6(self):
        self.assertEqual(split_sentence('!!! ,,, ... ;;;'), [])
    def test7(self):
        self.assertEqual(split_sentence('Apple apple APPLE'), ['apple'])
        
class SentenceTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(sentence_splitter('Red@Dragon....ca is great!'), ['reddragonca', 'is', 'great'])
    def test2(self):
        self.assertEqual(sentence_splitter('Hello, World! 123'), ['hello', 'world', '123'])
    def test3(self):
        self.assertEqual(sentence_splitter('test...test!!!test???test'), ['testtesttesttest'])
    def test4(self):
        self.assertEqual(sentence_splitter(''), [])
    def test5(self):
        self.assertEqual(sentence_splitter('   '), [])
    def test6(self):
        self.assertEqual(sentence_splitter('A@B#C$D%E^F&G*'), ['abcdefg'])
    def test7(self):
        self.assertEqual(sentence_splitter('My email is test@example.com'), ['my', 'email', 'is', 'testexamplecom'])
        
class StringTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(string_concat('dog'), 'ogg')
    def test2(self):
        self.assertEqual(string_concat('abc'), 'bcc')
    def test3(self):
        self.assertEqual(string_concat('a'), '')
    def test4(self):
        self.assertEqual(string_concat(''), '')
    def test5(self):
        self.assertEqual(string_concat('test'), 'essstttt')
    def test6(self):
        self.assertEqual(string_concat('hi'), 'ii')

if __name__ == '__main__':
    unittest.main(exit=True)