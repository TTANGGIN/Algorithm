"""
1. 인접 리스트를 사용하여 트리를 저장함
2. 인접 리스트 내에는 튜플로 (정점번호, 거리)로 이루어 진다.
3. DFS를 이용하여 각 간선으로부터 가장 먼 거리를 찾는다.
4. 임의의 노드에서 가장 멀리 떨어진 노드를 노드A라고 할 때, 노드A로 부터 가장 멀리 떨어진 노드는 최장 경로 보장이 되는 원리 활용
"""

import sys
input = sys.stdin.readline

V = int(input())
tree = [[] for _ in range(V + 1)]

for _ in range(V):
    edges = list(map(int, input().split()))
    for e in range(1, len(edges) - 1, 2):
        tree[edges[0]].append((edges[e], edges[e + 1]))


def dfs(start):
    visited = [False] * (V + 1)
    stack = [(start, 0)]
    max_dist, farthest_node = 0, start

    while stack:
        node, dist = stack.pop()
        if visited[node]:
            continue
        visited[node] = True
        if dist > max_dist:
            max_dist, farthest_node = dist, node
        for edge, weight in tree[node]:
            if not visited[edge]:
                stack.append((edge, dist + weight))
    return max_dist, farthest_node


_, farthest = dfs(1)

max_distance, _ = dfs(farthest)

print(max_distance)
