## Agents

Most of this workshop focuses on the building blocks of Spring AI: chat clients,
prompts, structured output, RAG, tool calling, and MCP. Once you're comfortable
with those, the natural next question is: how do I put them together into
something that can actually go do work on its own?

That's where agents come in.

An agent is a model that, given a goal, can reason about what to do next, use
tools to act, observe the results, and loop until the job is done without a
human directing each step. There's a useful distinction here between two styles:

- **Agentic workflows** still use an LLM and tools, but follow a predefined set
  of steps you wire up ahead of time. Deep research pipelines, classification
  chains, and most of what you'll see in this workshop fall into this bucket.
- **Autonomous agents** take a goal and decide their own next action, execute
  it, observe the result, and decide whether they're done. The plan-act-observe
  loop is driven by the model, not by you.

Both are valid, and both have their place. The two repos below show different
approaches to building autonomous agents in the Spring ecosystem.

### Building a Coding Agent with Spring AI Agent Utils

The [Spring AI Agent Utils](https://github.com/spring-ai-community/spring-ai-agent-utils)
project, part of the Spring AI Community, implements core Claude Code-inspired
capabilities as Spring AI tools: file system access, grep, glob, shell,
web fetch, and reusable skills. Combine those with a chat client and you have
the foundation for a coding agent that can read your codebase, run commands,
and make changes on its own.

I wrote a full walkthrough that builds a coding agent called Sprout from
scratch, including chat memory and skills for domain-specific behaviors:

- Blog post: [Spring, Build Me a Coding Agent](https://www.danvega.dev/blog/spring-building-me-a-coding-agent)
- Repo: [danvega/codingagent](https://github.com/danvega/codingagent)

Start here if you want to understand how agents work at the tool-and-loop
level, with nothing hidden behind a framework.

### Getting Started with Embabel

[Embabel](https://github.com/embabel/embabel-agent) is an agent framework for
the JVM built by Rod Johnson (the original creator of the Spring Framework).
Instead of handing the model a bag of tools and hoping it figures things out,
Embabel uses Goal-Oriented Action Planning (GOAP) to plan a path from the
current state to a desired goal, then executes that plan step by step. If
you've worked with agent frameworks that feel non-deterministic, this is a
refreshing alternative.

My blog-agent repo is a small project that uses Embabel to help draft and
manage blog content, and it's a good starting point for seeing how actions,
goals, and conditions fit together in a real Spring Boot app:

- Repo: [danvega/blog-agent](https://github.com/danvega/blog-agent)
- Video: https://youtu.be/G5VDQCZu6t0

Start here if you want a more structured, planning-first approach to agents
and are curious about what's coming next in the Spring agent space.

### Which should I look at first?

If you've never built an agent before, start with the coding agent. Seeing the
raw chat-client-plus-tools loop makes the concepts concrete. Once that clicks,
the blog-agent repo will give you a feel for how a planning framework like
Embabel changes the shape of the code you write.