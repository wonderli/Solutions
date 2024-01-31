from typing import List


class Solution:
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
