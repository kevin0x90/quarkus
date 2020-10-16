package io.quarkus.rest.runtime.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.quarkus.rest.runtime.mapping.URITemplate;

public class RestClientInterface {

    /**
     * The class name of the interface
     */
    private String className;

    /**
     * The class path
     */
    private String path;

    /**
     * The resource methods
     */
    private final List<ResourceMethod> methods = new ArrayList<>();

    private Set<String> pathParameters = new HashSet<>();

    public String getClassName() {
        return className;
    }

    public RestClientInterface setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RestClientInterface setPath(String path) {
        this.path = path;
        if (path != null) {
            pathParameters.clear();
            URITemplate.parsePathParameters(path, pathParameters);
        }
        return this;
    }

    public List<ResourceMethod> getMethods() {
        return methods;
    }

    public Set<String> getPathParameters() {
        return pathParameters;
    }

    public RestClientInterface setPathParameters(Set<String> pathParameters) {
        this.pathParameters = pathParameters;
        return this;
    }
}