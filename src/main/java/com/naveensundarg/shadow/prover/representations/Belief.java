package com.naveensundarg.shadow.prover.representations;

import com.naveensundarg.shadow.prover.utils.CollectionUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

/**
 * Created by naveensundarg on 5/4/16.
 */
public class Belief extends Formula{

    Value agent;
    Value time;
    Formula formula;
    Set<Formula> subFormulae;
    Set<Variable> variables;


    public Belief(Value agent, Value time, Formula formula) {


        this.agent = agent;
        this.time = time;
        this.formula = formula;
        this.subFormulae = formula.subFormulae();
        this.variables = CollectionUtils.setFrom(formula.variablesPresent());
        if (agent instanceof Variable) {
            variables.add((Variable) agent);
        }

        if (time instanceof Variable) {
            variables.add((Variable) time);

        }
    }

    public Formula getFormula(){
        return formula;
    }


    public Value getAgent() {
        return agent;
    }

    public Value getTime() {
        return time;
    }

    public Set<Formula> getSubFormulae() {
        return subFormulae;
    }

    public Set<Variable> getVariables() {
        return variables;
    }

    @Override
    public Set<Formula> subFormulae() {
        return null;
    }

    @Override
    public Set<Variable> variablesPresent() {
        return variables;
    }

    @Override
    public Formula apply(Map<Variable, Value> substitution) {
        return null;
    }

    @Override
    public Formula shadow(int level) {
        return new Atom("#"+toString()+"#");
    }

    @Override
    public Formula applyOperation(UnaryOperator<Formula> operator) {
        return null;
    }

    @Override
    public int getLevel() {
        return 2;
    }


    @Override
    public String toString() {
        return "(Believes! "
                + agent + " "
                + time + " "+
                formula + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Belief belief = (Belief) o;

        if (!agent.equals(belief.agent)) return false;
        if (!time.equals(belief.time)) return false;
        if (!formula.equals(belief.formula)) return false;
        if (subFormulae != null ? !subFormulae.equals(belief.subFormulae) : belief.subFormulae != null) return false;
        return variables != null ? variables.equals(belief.variables) : belief.variables == null;

    }

    @Override
    public int hashCode() {
        int result = agent.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + formula.hashCode();
        return result;
    }
}
