(define (reverse_list liste)
  (if (null? liste)
      '()
      (append (reverse_list (cdr liste)) (list (car liste)))))

; Example
(display "Original List: ")
(display '(1 2 3 4 5))
(newline)
(display "Inverted List: ")
(display (reverse_list '(1 2 3 4 5)))
(newline)

;In this definition, the reverse_list function has a recursive structure. First, using the if statement, it is checked whether the list is empty or not. If the list is empty (that is, the null? list expression is true), empty list() is returned. Otherwise, the else block runs.

;In the else block, the first element of the list is taken with car list and a new list is created using the list function. Then, with the cdr list, the first element of the list is removed and the remaining list is returned to the reverse_list function.

;Then, these recursive calls are combined with the append function and finally, the elements of the list are returned inverted.

;The cdr function skips the leading element of a pair or a list and returns all remaining elements.

;The car function returns the first element at the beginning of a pair or a list. That is, it takes the "head" (first element) of a list or a pair.

(display "*****************************************")
(newline)

(define liste '(1 2 3 4 2 3 5))

(define (removeDuplicates lst)
  (define (removeDuplicates-mr lst acc)
    (cond ((null? lst) acc) ; Empty List
          ((member (car lst) (cdr lst)) ; If the first element of the list repeats in the list
           (removeDuplicates-mr (cdr lst) acc)) ; Repeat the process, skipping the first element
          (else ; If the first element does not repeat in the list
           (removeDuplicates-mr (cdr lst) (cons (car lst) acc))))) ; Add first element to clean list
  (list lst (reverse (removeDuplicates-mr lst '())))) ; Return original list and non-duplicate list

; Example
(define result (removeDuplicates liste))
(display "Original List: ")
(display (car result))
(newline)
(display "List after removing duplicates:: ")
(display (cdr result))
(newline)

;In this definition, the removeDuplicates function calls the removeDuplicates-mr function, which is a recursive helper function. removeDuplicates-mr takes two arguments: lst (operated list) and acc (backlog).

;The removeDuplicates-mr function checks each element of the processed list and filters out duplicate elements. If an element repeats in the list, it is skipped by not adding that element to the backlog. If the element does not occur repeatedly in the list, it adds that element to the backlog. As a result of this process, the backlog contains non-repeated elements from the original list.

;As a result, the removeDuplicates function returns a duplicate containing the original list and the non-duplicated list. This pair is created with the list function. The first element is the original list and the second element is the non-repeated list.

;cond is a control structure that allows a Scheme expression to perform different operations based on multiple conditions. The if-else in many programming languages is similar to the if-else construct, but cond is more flexible and allows you to combine multiple conditions into a single block.

;reverse is an operation that reverses the elements of a Scheme list. This reverses the order of the list, moving the first element of the list to the end, the second element to the second, and so on.

;cons is a basic operation used to create a new list in the Scheme programming language.

;member is a Scheme operation that checks whether a particular element exists within a list. If the specified item is in the list, the member operation returns the item after its first appearance in the list. If the item is not in the list, #f (false) is returned.

(display "*****************************************")
(newline)

(define (listeleri-birlestir liste1 liste2)
  (append liste1 liste2))

; Example
(define liste1 '(1 2 3))
(define liste2 '(4 5 6))
(define birlesik-liste (listeleri-birlestir liste1 liste2))
(display "list 1: ")
(display liste1)
(newline)
(display "list 2: ")
(display liste2)
(newline)
(display "Merged List: ")
(display birlesik-liste)
(newline)

;This Scheme code defines a function that takes two lists and combines them. The name of the defined function is lists-merge.

;In this definition, lists list1 and list2 are combined using the append function. append concatenates the given lists recursively and creates a new list.


(display "*****************************************")
(newline)

(define liste1 '(1 2 3 4 5 6 7))
(define liste2 '(3 4 5 6 7 8 9))

(define (kesisim-bul liste1 liste2)
  ; We define a utility function to find the intersection of two lists
  (define (yardimci kum1 kum2)
    ; We check the elements in the first set with a loop
    (cond ((null? kum1) '()) ; If the first set is empty, the intersection must be empty
          ((member (car kum1) kum2) ; If the first element of the set contains the other set
           (cons (car kum1) (yardimci (cdr kum1) kum2))) ; We add the element to the intersection list
          (else
           (yardimci (cdr kum1) kum2)))) ; In the other case, we continue the loop

  ; We call the helper function on two lists
  (yardimci liste1 liste2))

; Example
(display "list 1: ")
(display liste1)
(newline)
(display "list 2: ")
(display liste2)
(newline)
(display "Intersection: ")
(display (kesisim-bul liste1 liste2))
(newline)

;This Scheme code defines a function that finds the intersection of two lists. This function takes two lists named list1 and list2 and returns a new list containing the elements at the intersection of these lists.

;In this definition, the find-intersection function finds the intersection using a recursive structure. A helper function (helper) is defined to navigate over two lists. This utility function takes two sets named sand1 and sand2 and finds the elements at the intersection.

;The helper function checks the following conditions with the cond statement:

;If sand1 is empty, the intersection is also empty (null? sand1).

;If the first element of kum1 is in kum2 ((member (car kum1) kum2)), it adds that element to the intersection list and calls the helper function recursively for the remaining elements.

;Otherwise, if the first element of sand1 is not in sand2, it calls the helper function recursively for the remaining elements of sand1.

;The find-intersection function finds the intersection by calling the helper function with list1 and list2 and returns this intersection.

(display "*****************************************")
(newline)


;OKTAY KAYA
;
;20132595298