from typing import List


class Solution:

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
