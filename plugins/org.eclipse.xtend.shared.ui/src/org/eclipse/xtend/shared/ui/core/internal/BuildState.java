package org.eclipse.xtend.shared.ui.core.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.internal.xtend.util.Pair;
import org.eclipse.internal.xtend.util.Triplet;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

public class BuildState {
	public static final String GLOBALVARNAME = BuildState.class.getName();

	private Map<Pair<String, List<Type>>, Type> extensionsReturnTypeCache = new HashMap<Pair<String,List<Type>>, Type>();
	private Map<Resource, Set<Extension>> allExtensionsPerResource = new HashMap<Resource, Set<Extension>>();
	private Map<ResourceID, Set<AnalysationIssue>> issuesPerResource = new HashMap<ResourceID, Set<AnalysationIssue>>();
	private Map<Triplet<Resource, String, List<Type>>, Extension> extensionForTypesCache = new WeakHashMap<Triplet<Resource, String, List<Type>>, Extension>();

	public Map<Pair<String, List<Type>>, Type> getExtensionsReturnType() {
		return extensionsReturnTypeCache;
	}

	public Map<Resource, Set<Extension>> getAllExtensionsPerResource() {
		return allExtensionsPerResource;
	}

	public Map<ResourceID, Set<AnalysationIssue>> getIssuesPerResource() {
		return issuesPerResource;
	}
	
	public Map<Triplet<Resource, String, List<Type>>, Extension> getExtensionForTypes() {
		return extensionForTypesCache;
	}

	public static BuildState get (ExecutionContext ctx) {
		final Variable v = ctx.getGlobalVariables().get(GLOBALVARNAME);
		return (BuildState) (v != null ? v.getValue() : null);
	}

}
