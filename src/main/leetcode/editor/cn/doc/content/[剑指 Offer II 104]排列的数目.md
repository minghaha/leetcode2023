<p>给定一个由 <strong>不同</strong>&nbsp;正整数组成的数组 <code>nums</code> ，和一个目标整数 <code>target</code> 。请从 <code>nums</code> 中找出并返回总和为 <code>target</code> 的元素组合的个数。数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。</p>

<p>题目数据保证答案符合 32 位整数范围。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], target = 4
<strong>输出：</strong>7
<strong>解释：</strong>
所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
请注意，顺序不同的序列被视作不同的组合。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [9], target = 3
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 200</code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li> 
 <li><code>1 &lt;= target &lt;= 1000</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？</p>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 377&nbsp;题相同：<a href="https://leetcode-cn.com/problems/combination-sum-iv/">https://leetcode-cn.com/problems/combination-sum-iv/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 51, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，第 16 期刷题打卡 [最后一天报名](https://aep.xet.tech/s/46nofd)。**

</div>



