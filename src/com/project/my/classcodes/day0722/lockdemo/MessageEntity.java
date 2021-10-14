package com.project.my.classcodes.day0722.lockdemo;

public class MessageEntity {
	private String dest;
	private String msg;

	public MessageEntity(String dest, String msg) {
		this.dest = dest;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public String getDest() {
		return dest;
	}

	public MessageEntity setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode()); // msg A 65 // msg D 69
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageEntity other = (MessageEntity) obj;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}



}
