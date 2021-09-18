defmodule Solution do
  @spec intersect(nums1 :: [integer], nums2 :: [integer]) :: [integer]
  def intersect(nums1, nums2) do
        nums1 -- (nums1 -- nums2)                                     
  end
end