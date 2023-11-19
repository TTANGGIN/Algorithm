"""
1. 인접 리스트를 이용하여 각 간선을 표시
2. BFS 또는 DFS를 이용하여 어떤 노드가 부모 노드인지 판별
"""


def main():
    answer = []
    node_count = int(input())
    tree = [[] for _ in range(node_count + 1)]
    for i in range(node_count - 1):
        node = list(map(int, input().split()))
        tree[node[0]].append(node[1])
        tree[node[1]].append(node[0])

    answer = dfs(tree)

    for a in answer:
        print(a)


def dfs(tree):
    N = len(tree)
    parents = [None] * N
    visited = [False] * N
    stack = [1]

    while stack:
        node = stack.pop()
        visited[node] = True
        for neighbor in tree[node]:
            if not visited[neighbor]:
                parents[neighbor] = node
                stack.append(neighbor)

    return parents[2:]


main()
