package com.bridgelabz.springboot.response;

public class Response {
	private String statusInfo;
	private long statusId;
	private Object object;
	
	public Response() {
		
	}
	public Response(String statusInfo, long statusId) {
		super();
		this.statusInfo = statusInfo;
		this.statusId = statusId;
	}
	public Response(String statusInfo, long statusId, Object object) {
		this.statusInfo = statusInfo;
		this.statusId = statusId;
		this.object = object;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
