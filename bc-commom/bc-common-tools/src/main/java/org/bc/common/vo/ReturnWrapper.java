package org.bc.common.vo;

public class ReturnWrapper<T> {
	private T resultObject;

	public ReturnWrapper(T result) {
		if (result != null) {
			this.resultObject = result;
		}
	}

	public ReturnWrapper() {
	}

	public AppResult<T> success(String message) {
		AppResult<T> appResult = new AppResult<>();
		appResult.setCode(Constant.ACCESS_CODE.SUCCESS.getCode());
		appResult.setMessage(message);
		appResult.setResults(resultObject);
		return appResult;
	}

	public AppResult<T> failed(String message) {
		AppResult<T> appResult = new AppResult<>();
		appResult.setCode(Constant.ACCESS_CODE.FAILED.getCode());
		appResult.setMessage(message);
		return appResult;
	}

	/**
	 * 超时
	 * @param message
	 * @return
	 */
	public AppResult<T> timeout(String message) {
		AppResult<T> appResult = new AppResult<>();
		appResult.setCode(Constant.ACCESS_CODE.TIMEOUT.getCode());
		appResult.setMessage(message);
		return appResult;
	}

	public AppResult<T> complete(T responseValue) {
		AppResult<T> appResult = new AppResult<>();
		appResult.setCode(Constant.ACCESS_CODE.SUCCESS.getCode());
		appResult.setMessage(Constant.ACCESS_CODE.SUCCESS.getName());
		appResult.setResults(responseValue);
		return appResult;
	}
}
