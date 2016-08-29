package br.com.quintoandar.amplitude.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@Path("/api/2")
public interface ExportApi {
	
	public static final String ISO_8601_DATE_PATTERN = "yyyy-MM-dd hh:MMZ";
	
	public static final String FILTER_DATE_PATTERN = "yyyyMMddTHH";

	@Path("/export")
	public List<Event> export(
			@HeaderParam("Authorization")
			String authorization,
				@QueryParam("start")
				@JsonFormat(pattern=FILTER_DATE_PATTERN) 
				Date start,
					@QueryParam("end")
					@JsonFormat(pattern=FILTER_DATE_PATTERN) 
					Date end
	);

	public static final class Event {

		Integer app;

		@JsonProperty("amplitude_id")
		Long amplitudeId;

		@JsonProperty("user_id")
		String userId;

		@JsonProperty("device_id")
		String deviceId;

		@JsonProperty("event_time")
		@JsonFormat(pattern = ISO_8601_DATE_PATTERN)
		Date eventTime;

		@JsonProperty("server_upload_time")
		@JsonFormat(pattern = ISO_8601_DATE_PATTERN)
		Date serverUploadTime;

		@JsonProperty("client_event_time")
		Date clientEventTime;

		@JsonProperty("client_upload_time")
		Date clientUploadTime;

		@JsonProperty("event_id")
		Integer eventId;

		@JsonProperty("session_id")
		Long sessionId;

		@JsonProperty("event_type")
		String eventType;

		@JsonProperty("amplitude_event_type")
		String amplitudeEventType;

		@JsonProperty("version_name")
		String versionName;

		@JsonProperty("event_properties")
		Map<String, Object> eventProperties;

		@JsonProperty("user_properties")
		Map<String, Object> userProperties;

		Map<String, Object> data;
	}

}
