from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        queue = deque()
        queue.append(root)
        res = []
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if i == size - 1:
                    res.append(curr.val)
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
        return res

    def minimumLength(self, s: str) -> int:
        i = 0
        j = len(s) -1
        while i < j and s[i] == s[j]:
            c = s[i]
            while i <= j and s[i] == c:
                i+= 1
            while j > i and s[j] == c:
                j-=1
        return j - i + 1
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        if root == p or root == q:
            return root
        
        l = self.lowestCommonAncestor(root.left, p, q)
        r = self.lowestCommonAncestor(root.right, p, q)
        if l == None:
            return r
        if r == None:
            return l
  
        return root

    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        score = 0
        tokens.sort()
        deque = collections.deque(tokens)
        while deque:
            if power >= deque[0]:
                power -= deque.popleft()
                score += 1
            elif len(deque) > 2 and score > 0:
                power += deque.pop()
                score -= 1
            else:
                return score
        return score

    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        
        pathLength = 0
        def dfs(node: Optional[TreeNode], goLeft: bool, steps: int):
            if node == None:
                return
            nonlocal pathLength
            pathLength = max(pathLength, steps)
            if goLeft:
                dfs(node.left, False, steps+1)
                dfs(node.right, True, 1)
            else:
                dfs(node.left, False, 1)
                dfs(node.right, True, steps+1)
        dfs(root, False, 0)
        dfs(root, True, 0)
        return pathLength

    def goodNodes(self, root: TreeNode) -> int:
        
        def dfs(node, max_so_far):
            if not node:
                return
            nonlocal res
            if max_so_far <= node.val:
                res += 1
                
            dfs(node.left, max(max_so_far, node.val))
            dfs(node.right, max(max_so_far, node.val))
            
        res = 0
        dfs(root, float("-inf"))
        return res
    
    def maximumOddBinaryNumber(self, s: str) -> str:
        nums = list(s)
        count = 0
        for e in nums:
            if e == '1':
                count += 1
        result = deque()
        length = len(nums)
        while length > 1:
            if count > 1:
                result.append('1')
                count -=1
            else:
                result.append('0')
            length -= 1
        result.append('1')
        
                
        return ''.join(result)
    
    def gameResult(self, head: Optional[ListNode]) -> str:
        odd = 0
        even = 0
        e = head
        
        
        while e  != None:
            o = e.next
            if e.val > o.val:
                even += 1
            else:
                odd += 1
            e = o.next
            
        if even > odd:
            return "Even"
        elif even == odd:
            return "Tie"
        else:
            return "Odd"
  
    def equalToDescendants(self, root: Optional[TreeNode]) -> int:
        res = 0
            
        def count(root: Optional[TreeNode]) -> int:
            
            if not root:
                return 0
            nonlocal res
            l = count(root.left)
            r = count(root.right)
            if root.val == l + r:
                res += 1
            return root.val + l + r
        
        count(root)
        return res
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
    def predictPartyVictory(self, senate: str) -> str:
        n = len(senate)
        r_queue = deque()
        d_queue = deque()
        for i, s in enumerate(senate):
            if s == 'R':
                r_queue.append(i)
            else:
                d_queue.append(i)
        while r_queue and d_queue:
            r_turn = r_queue.popleft()
            d_turn = d_queue.popleft()
            
            if d_turn < r_turn:
                d_queue.append(d_turn + n)
            else:
                r_queue.append(r_turn + n)
        return "Radiant" if r_queue else "Dire"
    def treeDiameter(self, edges: List[List[int]]) -> int:
        if len(edges) == 0:
            return 0
        graph = [set() for i in range(len(edges) + 1)]
        for edge in edges:
            u, v = edge
            graph[u].add(v)
            graph[v].add(u)
            
        def bfs(start):
            visited = [False] * len(graph)
            visited[start] = True
            queue = deque([start])
            distance = -1
            last_node = None
            while queue:
                next_queue = deque()
                while queue:
                    next_node = queue.popleft()
                    for neighbor in graph[next_node]:
                        if not visited[neighbor]:
                            visited[neighbor] = True
                            next_queue.append(neighbor)
                            last_node = neighbor
                distance += 1
                queue = next_queue

            return last_node, distance
        farthest_node, distance_1 = bfs(0)
        another_farthest_node, distance_2 = bfs(farthest_node)
        
        return distance_2
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        arr = [0] * (n+1)
        for e in trust:
            a = e[0]
            b = e[1]
            arr[a] -= 1
            arr[b] += 1
        for i in range(1, n+1):
            if arr[i] == n-1:
                return i
        return -1
    def decodeString(self, s: str) -> str:
        stack = []
        curr_str = ""
        curr_num = 0
        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == "[":
                stack.append(curr_num)
                stack.append(curr_str)
                curr_num = 0
                curr_str = ""
            elif c == "]":
                prev_str = stack.pop()
                prev_num = stack.pop()
                curr_str = prev_str + curr_str * prev_num
            else:
                curr_str += c
            
        while stack:
            curr_str = stack.pop() + curr_str
            
        return curr_str
    
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        while left < right:
            right = right & (right - 1)
        return left & right
        
    def missingNumber(self, nums: List[int]) -> int:
        x = len(nums)
        for i in range(len(nums)):
            x = x ^ i
            x = x ^ nums[i]
        return x
    def removeStars(self, s: str) -> str:
        stack = []
        for e in s:
            if e != '*':
                stack.append(e)
            else:
                stack.pop()
        return ''.join(stack)
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False
        return (n & (-n)) == n
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        m = {}
        for e in arr:
            m[e] = m.get(e, 0) + 1        
        
        return len(set(m.values())) == len(set(m.keys()))
    
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False
        m1 = {}
        m2 = {}
        for e in word1:
            m1[e]  = m1.get(e, 0) + 1
        for e in word2:
            m2[e] = m2.get(e, 0) + 1
        if set(m1.keys()) != set(m2.keys()):
            return False
        
        sm1 = sorted(m1.values())
        sm2 = sorted(m2.values())
        return sm1 == sm2
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        map1 = set()
        map2 = set()
        res1 = []
        res2 = []
        for e in nums1:
            map1.add(e)
        for e in nums2:
            map2.add(e)
        for e in map1:
            if e not in map2:
                res1.append(e)
        for e in map2:
            if e not in map1:
                res2.append(e)
        res = [[], []]
        res[0] = res1
        res[1] = res2
        return res
        
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n
        pos_index, neg_index = 0, 1
        for i in range(n):
            if nums[i] > 0:
                res[pos_index] = nums[i]
                pos_index += 2
            else:
                res[neg_index] = nums[i]
                neg_index += 2
        return res
    def pivotIndex(self, nums: List[int]) -> int:
        n = len(nums)

        leftSum = [0 for _ in range(n)]
        lSum = 0
        rightSum = [0 for _ in range(n)]
        RSum = 0
        for i in range(1, n):
            leftSum[i] = leftSum[i-1] + nums[i-1]
        for i in range(n-2, -1, -1):
            rightSum[i] = rightSum[i+1] + nums[i+1]
            
        for i in range(0, n):
            if leftSum[i] == rightSum[i]:
                return i
        return -1
    def firstPalindrome(self, words: List[str]) -> str:
        for i in range(len(words)):
            if self.isPalindrome(words[i]):
                return words[i]
        return ""
    def isPalindrome(self, word: str) -> bool:
        i = 0
        j = len(word) - 1
        while i < j:
            if word[i] == word[j]:
                i += 1
                j -= 1
            else:
                return False
        return True
    
    def largestAltitude(self, gain: List[int]) -> int:
        n = len(gain)
        res = 0
        sum = [0 for _ in range(n+1)]
        for i in range(1, n+1):
            sum[i] += sum[i-1] + gain[i-1]
            res = max(res, sum[i])
        return res
    def longestSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        count = 0
        i = 0
        res = 0
        
        for j in range(n):
            count += 1 if nums[j] == 0 else 0
            
            while count > 1:
                count -= 1 if nums[i] == 0 else 0
                i += 1
            res = max(res, j - i)
        return res

    def findMaxAverage(self, nums: List[int], k: int) -> float:
        sum = 0
        for i in range(k):
            sum += nums[i]
        res = sum
        for i in range(k, len(nums)):
            sum += nums[i] - nums[i-k]
            res = max(res, sum)
        return res/k

    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        i = 0
        n = len(nums)
        j = n-1
        count = 0
        while i < j:
            if nums[i] + nums[j] == k:
                i += 1
                j -= 1
                count += 1
            elif nums[i] + nums[j] > k:
                j -= 1
            else:
                i += 1
        return count

    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        i = 0
        j = n-1
        area = 0
        while i < j:
            l = height[i]
            r = height[j]
            h = min(l, r)
            w = j - i 
            area = max(area, h * w)
            if l < r:
                i += 1
            else:
                j -= 1
        return area
    def isSubsequence(self, s: str, t: str) -> bool:
        n = len(s)
        m = len(t)
        if n == 0:
             return True
        if n > m: 
            return False
        i = 0
    
        for c in t:
            if c == s[i]:
                i += 1
            if i == len(s):
                 return True
        return False        

    def compress(self, chars: List[str]) -> int:
        count = 1
        l = 0
        
        for r in range(1, len(chars)+1):
            if r < len(chars) and chars[r-1] == chars[r]:
                count += 1
            else:
                chars[l] = chars[r - 1]
                l += 1
                if count > 1:
                    for c in str(count):
                        chars[l] = c
                        l += 1
                count = 1
        return l
    
    def increasingTriplet(self, nums: List[int]) -> bool:
        n = len(nums)
        if n < 3:
            return False
        first = float('inf')
        second = float('inf')
        for e in nums:
            if e <= first:
                first = e
            elif e <= second:
                second = e
            else:
                return True
        return False



    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = 1
        postfix = 1
        n = len(nums)
        result = [1] * n
        for i in range(n):
            result[i] *= prefix
            prefix *= nums[i]
        for j in range(n -1, -1, -1):
            result[j] *= postfix
            postfix *= nums[j]
        return result


    def reverseWords(self, s: str) -> str:
        i = 0
        j = len(s) - 1
        ss = list(s)
        while i <= j and ss[i] == ' ':
            i += 1
        while i <= j and ss[j] == ' ':
            j -= 1
        ss = ss[i:j + 1]
        self.reverse(ss, 0, len(ss) - 1)
        i = 0
        j = len(ss) - 1
        result = []
        while i <= j:
            p = i
            while p <= j and ss[p] != ' ':
                p += 1
            self.reverse(ss, i, p - 1)
            for e in range(i, p):
                result.append(ss[e])
            while p <= j and ss[p] == ' ':
                p += 1
            if p <= j:
                result.append(' ')
            i = p
        return ''.join(result)

    def reverse(self, ss: list, i: int, j: int) -> list:
        while i < j:
            t = ss[i]
            ss[i] = ss[j]
            ss[j] = t
            i += 1
            j -= 1
        return ss

    def reverseVowels(self, s: str) -> str:
        set = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        ss = list(s)
        i = 0
        j = len(ss) - 1
        while i < j:
            while i < j and ss[i] not in set:
                i += 1
            while i < j and ss[j] not in set:
                j -= 1
            t = ss[i]
            ss[i] = ss[j]
            ss[j] = t
            i += 1
            j -= 1

        return ''.join(ss)

    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        count = 0
        for i in range(len(flowerbed)):
            if flowerbed[i] == 0 and (i == 0 or flowerbed[i - 1] == 0) and (
                    i == len(flowerbed) - 1 or flowerbed[i + 1] == 0):
                flowerbed[i] = 1
                count += 1

        return count >= n

    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxValue = max(candies)
        n = len(candies)
        result = [False for _ in range(n)]
        for i in range(0, n):
            result[i] = (candies[i] + extraCandies) >= maxValue
        return result

    def gcd(self, x: int, y: int) -> int:
        if y == 0:
            return x
        else:
            return self.gcd(y, x % y)

    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if (str1 + str2) != (str2 + str1):
            return ""
        gcdLen = self.gcd(len(str1), len(str2))
        return str1[0: gcdLen]

    def mergeAlternately(self, word1: str, word2: str) -> str:
        p1 = 0
        p2 = 0
        result = ""
        while p1 < len(word1) and p2 < len(word2):
            result += word1[p1]
            p1 += 1
            result += word2[p2]
            p2 += 1
        if p1 < len(word1):
            result += word1[p1:]
        if p2 < len(word2):
            result += word2[p2:]
        return result

    def checkIfExist(self, arr: List[int]) -> bool:
        s = set()
        for e in arr:
            if e * 2 in s or (e % 2 == 0 and e / 2 in s):
                return True
            s.add(e)
        return False

    def removeElement(self, nums: List[int], val: int) -> int:
        length = len(nums)
        i = -1
        j = 0
        while j < length:
            if nums[j] == val:
                j += 1
            else:
                i += 1
                t = nums[i]
                nums[i] = nums[j]
                nums[j] = t
                j += 1

        return i + 1

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        p1 = m - 1
        p2 = n - 1
        for p in range(n + m - 1, -1, -1):
            if p2 < 0:
                break
            if p1 >= 0 and nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1


class RecentCounter:

    def __init__(self):
        self.slide_window = deque()

    def ping(self, t: int) -> int:
        self.slide_window.append(t)
        while self.slide_window[0] < t - 3000:
            self.slide_window.popleft()
        return len(self.slide_window)
    

