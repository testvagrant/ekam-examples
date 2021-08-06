package com.testvagrant.ekamexamples.workflow;

public interface Workflow<Layout, Next> {

  Layout create();

  Next next();
}
