package com.example.dependencyinversionprinciple.presentation.registry.home

interface HomeRegistry<V, P> {
    fun provide(view: V): P
}