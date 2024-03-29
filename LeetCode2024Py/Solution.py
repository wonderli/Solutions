import collections
import heapq
from collections import defaultdict, deque
from math import inf
from typing import List, Optional


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
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        start = 0
        freq = Counter()
        max_len = 0
        for end in range(n):
            freq[nums[end]] += 1
            while freq[nums[end]] > k:
                freq[nums[start]] -= 1
                start += 1
            max_len = max(max_len, end - start + 1)
        return max_len
    def maxProfit(self, prices: List[int]) -> int:
        min_price = inf
        max_profit = 0
        for price in prices:
            min_price = min(min_price, price)
            max_profit = max(max_profit, price - min_price)
        return max_profit
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k%n
        def reverse(nums: List[int], x: int, y: int):
            while x < y:
                nums[x], nums[y] = nums[y], nums[x]
                x +=1
                y -= 1
        reverse(nums, 0, n-1)
        reverse(nums, k, n-1)
        reverse(nums, 0, k-1)
    def majorityElement(self, nums: List[int]) -> int:
        major = nums[0]
        count = 1
        for num in nums[1:]:
            if count == 0:
                major = num
                count = 1
            elif major == num:
                count += 1
            else:
                count -= 1
        return major
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals.sort(key=lambda x: (x[1]))
        end = intervals[0][1]
        count = 0
        for interval in intervals[1:]:
            s = interval[0]
            e = interval[1]
            if s < end:
                count += 1
            else:
                end = e
        return count
    def minFlips(self, a: int, b: int, c: int) -> int:
        flips = 0
        while a > 0 or b > 0 or c > 0:
            bit_a = a & 1
            bit_b = b & 1
            bit_c = c & 1
            if bit_c == 1 and bit_a == 0 and bit_b == 0:
                flips += 1
            elif bit_c == 0:
                if bit_a == 1:
                    flips += 1
                if bit_b == 1:
                    flips += 1
            a >>= 1
            b >>= 1
            c >>= 1
        return flips
    def minDistance(self, word1: str, word2: str) -> int:
        m= len(word1)
        n = len(word2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(min(dp[i - 1][j - 1]+1, dp[i][j - 1]+1), dp[i - 1][j]+1)
        return dp[m][n]
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        cash, hold = 0, -prices[0] - fee
        for i in range(n):
            cash = max(cash, hold + prices[i])
            hold = max(hold, cash - prices[i] - fee)
        return cash
    def removeVowels(self, s: str) -> str:
        vowels = set(['a', 'e', 'i', 'o', 'u'])
        n = len(s)
        l = list(s)
        i = 0
        j = 0
        while j < n:
            if l[j] in vowels:
                j += 1
            else:
                t = l[i]
                l[i] = l[j]
                l[j] = t
                i += 1
                j += 1
        return ''.join(l[:i])
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        stack = []
        p1 = head
        p2 = head
        while p2 and p2.next:
            stack.append(p1.val)
            p1 = p1.next
            p2 = p2.next.next

        if p2:
            p1 = p1.next

        i = 0
        while p1:
            top = stack.pop()
            if top != p1.val:
                return False
            p1 = p1.next
        return True
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m = len(text1)
        n = len(text2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        return dp[m][n]
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        curr = None
        next = head
        while next != None:
            p = next.next
            next.next = curr
            curr = next
            next = p
        return curr
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0], nums[1])
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

        return dp[n - 1]
    def tribonacci(self, n: int) -> int:
        dp = [0] * (n+1)
        if n == 0:
            return 0
        if n == 1 or n == 2:
            return 1
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1
        for i in range(3, n+1):
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
        return dp[n]
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def helper(start: int, curr: List[int], remain: int, res: List[List[int]]):
            if len(curr) == k and remain == 0:
                res.append(list(curr))
                return

            for i in range(start, 10):
                if remain - i >= 0:
                    curr.append(i)
                    helper(i + 1, curr, remain - i, res)
                    curr.pop()

        result = []
        helper(1, [], n, result)
        return result
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        pre = list1
        for i in range(a - 1):
            pre = pre.next

        after = pre
        for j in range(b - a + 2):
            after = after.next
        tail = list2

        while tail.next:
            tail = tail.next
        pre.next = list2
        tail.next = after
        return list1

    def leastInterval(self, tasks: List[str], n: int) -> int:
        tasks_count = collections.Counter(tasks)

        max_tasks = max(tasks_count.values())
        max_count = list(tasks_count.values()).count(max_tasks)
        res = max(len(tasks), (max_tasks - 1) * (n + 1) + max_count)
        return res
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        while l < r:
            mid = (l + r)//2
            if nums[mid] > nums[mid+1]:
                r = mid
            else:
                l = mid+1
        return l
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        n, m = len(spells), len(potions)
        potions.sort()
        res = []

        def bin_search(target) -> int:
            l, r = 0, m
            while l < r:
                mid = (l + r) // 2

                if spells[i] * potions[mid] < target:
                    l = mid + 1
                else:
                    r = mid
            return l

        for i in range(n):
            count = m - bin_search(success)
            res.append(count)
        return res

    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        head_workers = []
        tail_workers = []
        for i in range(candidates):
            heapq.heappush(head_workers, costs[i])
        for i in range(max(candidates, len(costs) - candidates), len(costs)):
            heapq.heappush(tail_workers, costs[i])
        res = 0
        next_head = candidates
        next_tail = len(costs) - 1 - candidates

        for i in range(k):
            if not tail_workers or head_workers and (head_workers[0] <= tail_workers[0]):
                res += heapq.heappop(head_workers)

                if next_head <= next_tail:
                    heapq.heappush(head_workers, costs[next_head])
                    next_head += 1
            else:
                res += heapq.heappop(tail_workers)
                if next_head <= next_tail:
                    heapq.heappush(tail_workers, costs[next_tail])
                    next_tail -= 1
        return res

    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        pairs = sorted(zip(nums1, nums2), key=lambda x: x[1], reverse=True)
        top_k_sum = 0
        min_heap = []
        for i in range(k):
            top_k_sum += pairs[i][0]
            heapq.heappush(min_heap, pairs[i][0])

        res = top_k_sum * pairs[k - 1][1]
        for i in range(k, len(nums2)):
            top_k_sum += pairs[i][0] - heapq.heappop(min_heap)
            heapq.heappush(min_heap, pairs[i][0])
            res = max(res, top_k_sum * pairs[i][1])
        return res

    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if not points:
            return 0
        points.sort(key=lambda x: x[1])
        currEnd = points[0][1]
        count = 1
        for point in points[1:]:
            if point[0] > currEnd:
                count += 1
                currEnd = point[1]

        return count

    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        intervals.sort(key=lambda x: (x[0], x[1]))
        n = len(intervals)

        start = intervals[0][0]
        end = intervals[0][1]
        result = []
        for i in range(1, n):
            curr = intervals[i]
            curr_start, curr_end = curr[0], curr[1]
            if curr_start > end:
                result.append([start, end])
                start = curr_start
                end = curr_end
            else:
                start = min(start, curr_start)
                end = max(curr_end, end)

        result.append([start, end])
        return result

    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        if not maze:
            return -1
        n = len(maze)
        m = len(maze[0])
        visited = set()
        q = deque()
        q.append((entrance[0], entrance[1], 0))
        visited.add((entrance[0], entrance[1]))
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while q:
            curr = q.popleft()
            if (curr[0] == 0 or curr[0] == n - 1 or curr[1] == 0 or curr[1] == m - 1) and (
                    (curr[0], curr[1]) != (entrance[0], entrance[1])):
                return curr[2]
            for dir in directions:
                x, y = curr[0] + dir[0], curr[1] + dir[1]
                if 0 <= x < n and 0 <= y < m and (x, y) not in visited and maze[x][y] == '.':
                    q.append((x, y, curr[2] + 1))
                    visited.add((x, y))

        return -1


def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
    if not maze:
        return 0
    n = len(maze)
    m = len(maze[0])
    q = deque()
    visited = set()
    q.append((entrance[0], entrance[1], 0))
    visited.add(entrance)
    directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    while not q:
        curr = q.popleft()
        for dir in directions:
            newX = curr[0] + dir[0]
            newY = curr[1] + dir[1]
            if ((newX == 0 or newX == n - 1) and (newY == 0 or newY == m - 1) and (
                    [newX, newY] not in visited) and maze[newX][newY] == '.'):
                return curr[2] + 1
            else:
                if [newX, newY] not in visited and maze[newX][newY] == '.':
                    q.append((newX, newY, curr[2] + 1))

    return -1


def minMeetingRooms(self, intervals: List[List[int]]) -> int:
    if not intervals:
        return 0
    intervals.sort(key=lambda x: x[0])
    free_rooms = []
    heapq.heappush(free_rooms, intervals[0][1])
    for interval in intervals[1:]:
        start = interval[0]
        if free_rooms[0] <= start:
            heapq.heappop(free_rooms)
        heapq.heappush(free_rooms, interval[1])

    return len(free_rooms)


def productExceptSelf(self, nums: List[int]) -> List[int]:
    n = len(nums)
    left = [1] * n
    right = [1] * n
    for i in range(1, n):
        left[i] = nums[i - 1] * left[i - 1]

    for j in range(n - 2, -1, -1):
        right[j] = nums[j + 1] * right[j + 1]
    res = [1] * n
    for i in range(0, n):
        res[i] = left[i] * right[i]
    return res


def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
    graph = defaultdict(dict)
    n = len(values)
    for i in range(n):
        equation = equations[i]
        a = equation[0]
        b = equation[1]
        v = values[i]
        graph[a][b] = v
        graph[b][a] = 1 / v

    def dfs(start: int, end: int, res: int, seen: set):
        if start in seen:
            return -1.0
        if start == end:
            return res
        seen.add(start)
        for e in graph[start]:
            if e not in seen:
                t = dfs(e, end, res * graph[start][e], seen)
                if t != -1.0:
                    return t
        return -1.0

    m = len(queries)
    res = [0] * m
    for i in range(m):
        query = queries[i]
        c = query[0]
        d = query[1]
        if c not in graph or d not in graph:
            res[i] = -1.0
        else:
            res[i] = dfs(c, d, 1, set())

    return res


def minReorder(self, n: int, connections: List[List[int]]) -> int:
    graph = defaultdict(list)
    edges = set()
    for u, v in connections:
        edges.add((u, v))
        graph[u].append(v)
        graph[v].append(u)
    visited = {0}
    res = 0

    def dfs(city):
        nonlocal graph, visited, res, edges
        for nei in graph[city]:
            if nei in visited:
                continue
            if (nei, city) not in edges:
                res += 1
            visited.add(nei)
            dfs(nei)

    dfs(0)
    return res


def pivotInteger(self, n: int) -> int:
    left = 1
    right = n
    totalSum = int(n * (n + 1) / 2)
    while left < right:
        mid = int((left + right) / 2)
        if (mid * mid - totalSum < 0):
            left = mid + 1
        else:
            right = mid

    if (left * left - totalSum == 0):
        return left
    else:
        return -1


def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
    front = ListNode(0, head)
    curr = front
    prefixSum = 0
    prefixSumToNode = {0: front}

    while curr is not None:
        prefixSum += curr.val
        prefixSumToNode[prefixSum] = curr
        curr = curr.next

    prefixSum = 0
    curr = front
    while curr is not None:
        prefixSum += curr.val
        curr.next = prefixSumToNode[prefixSum].next
        curr = curr.next
    return front.next


def customSortString(self, order: str, s: str) -> str:
    map = {}
    for i in range(len(order)):
        map[order[i]] = i

    cs = list(s)
    ss = sorted(cs, key=lambda x: map.get(x, 27))
    return ''.join(ss)


def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
    n = len(rooms)
    visited = [False] * n
    q = deque()
    q.append(0)
    visited[0] = True
    while len(q) != 0:
        curr = q.popleft()
        for e in rooms[curr]:
            if visited[e] != True:
                visited[e] = True
                q.append(e)

    for e in visited:
        if not e:
            return False
    return True


def frequenciesOfElements(self, head: Optional[ListNode]) -> Optional[ListNode]:
    if not head:
        return None
    frequencies = {}
    curr = head
    freqHead = None
    while curr != None:
        if curr.val in frequencies:
            fnode = frequencies[curr.val]
            fnode.val += 1
            frequencies[curr.val] = fnode
        else:
            newFNode = ListNode(1, freqHead)
            frequencies[curr.val] = newFNode
            freqHead = newFNode

        curr = curr.next
    return freqHead


def maxFrequencyElements(self, nums: List[int]) -> int:
    map = {}
    maxFrequency = 0
    totalFrequency = 0
    for e in nums:
        map[e] = map.get(e, 0) + 1
        f = map[e]
        if f > maxFrequency:
            maxFrequency = f
            totalFrequency = f
        elif f == maxFrequency:
            totalFrequency += f

    return totalFrequency


def successor(self, root: TreeNode) -> int:
    root = root.right
    while root.left:
        root = root.left
    return root.val


def predecessor(self, root: TreeNode) -> int:
    root = root.left
    while root.right:
        root = root.right
    return root.val


def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
    if not root:
        return None
    if key > root.val:
        root.right = self.deleteNode(root.right, key)
    elif key < root.val:
        root.left = self.deleteNode(root.left, key)
    else:
        if not (root.left or root.right):
            root = None
        elif root.right:
            root.val = self.successor(root)
            root.right = self.deleteNode(root.right, root.val)
        else:
            root.val = self.predecessor(root)
            root.left = self.deleteNode(root.left, root.val)
    return root


def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
    if root == None:
        return None
    if root.val == val:
        return root
    if root.val < val:
        return self.searchBST(root.right, val)
    else:
        return self.searchBST(root.left, val)


def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
    if head == None:
        return head
    p = head
    q = head
    while q != None and q.next != None:
        p = p.next
        q = q.next.next
    return p


def maxLevelSum(self, root: Optional[TreeNode]) -> int:
    if root == None:
        return 0
    level = 1
    res = 1
    maxSum = -inf
    q = deque()
    q.append(root)
    while q:
        size = len(q)
        currSum = 0

        for i in range(size):
            curr = q.popleft()
            currSum += curr.val
            if curr.left != None:
                q.append(curr.left)
            if curr.right != None:
                q.append(curr.right)
        if currSum > maxSum:
            maxSum = currSum
            res = level
        level += 1

    return res


def hasCycle(self, head: Optional[ListNode]) -> bool:
    p1 = head
    p2 = head
    while p1 != None and p2 != None and p2.next != None:
        p1 = p1.next
        p2 = p2.next.next
        if p1 == p2:
            return True
    return False


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
    j = len(s) - 1
    while i < j and s[i] == s[j]:
        c = s[i]
        while i <= j and s[i] == c:
            i += 1
        while j > i and s[j] == c:
            j -= 1
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
            dfs(node.left, False, steps + 1)
            dfs(node.right, True, 1)
        else:
            dfs(node.left, False, 1)
            dfs(node.right, True, steps + 1)

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
            count -= 1
        else:
            result.append('0')
        length -= 1
    result.append('1')

    return ''.join(result)


def gameResult(self, head: Optional[ListNode]) -> str:
    odd = 0
    even = 0
    e = head

    while e != None:
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
    arr = [0] * (n + 1)
    for e in trust:
        a = e[0]
        b = e[1]
        arr[a] -= 1
        arr[b] += 1
    for i in range(1, n + 1):
        if arr[i] == n - 1:
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
        m1[e] = m1.get(e, 0) + 1
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
        leftSum[i] = leftSum[i - 1] + nums[i - 1]
    for i in range(n - 2, -1, -1):
        rightSum[i] = rightSum[i + 1] + nums[i + 1]

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
    sum = [0 for _ in range(n + 1)]
    for i in range(1, n + 1):
        sum[i] += sum[i - 1] + gain[i - 1]
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
        sum += nums[i] - nums[i - k]
        res = max(res, sum)
    return res / k


def maxOperations(self, nums: List[int], k: int) -> int:
    nums.sort()
    i = 0
    n = len(nums)
    j = n - 1
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
    j = n - 1
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

    for r in range(1, len(chars) + 1):
        if r < len(chars) and chars[r - 1] == chars[r]:
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
    for j in range(n - 1, -1, -1):
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


class SmallestInfiniteSet:

    def __init__(self):
        self.minHeap = []
        self.nextSmallest = 1

    def popSmallest(self) -> int:
        if self.minHeap and self.minHeap[0] < self.nextSmallest:
            return heapq.heappop(self.minHeap)
        else:
            self.nextSmallest += 1
            return self.nextSmallest - 1

    def addBack(self, num: int) -> None:
        if num < self.nextSmallest and num not in self.minHeap:
            heapq.heappush(self.minHeap, num)


class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEndOfWord = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.isEndOfWord = True

    def search(self, word: str) -> bool:
        node = self.find(word)
        return node is not None and node.isEndOfWord

    def find(self, word: str) -> TrieNode:
        node = self.root
        for c in word:
            if c not in node.children:
                return None
            node = node.children[c]
        return node

    def startsWith(self, prefix: str) -> bool:
        node = self.find(prefix)
        return node is not None