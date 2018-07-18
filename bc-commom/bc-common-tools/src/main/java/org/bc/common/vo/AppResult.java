package org.bc.common.vo;

public class AppResult<T> extends BaseAppResult {
	private T results;

	public T getResults() {
		return results;
	}
	public void setResults(T results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return " {results:" + results + "} ";
	}

	public void succeed(T results){
        super.succeed();
        this.results = results;
    }

    public void fail(T results){
        super.fail();
        this.results = results;
    }

}
