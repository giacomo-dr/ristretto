package ch.usi.delrig.ristretto.typechecker;

import java.util.HashMap;

import ch.usi.delrig.ristretto.ast.NodeBase;

/**
 * This class is used to attach type attributes to nodes in the AST.
 * During the static analysis an entry in the map is created for
 * eache node that requires a type attribute.
 */
public class AstAttributeMap extends HashMap<NodeBase, Type>{
    private static final long serialVersionUID = 877299580781807862L;
}
