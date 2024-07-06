package com.example.postheart.appuser.marker;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.ToString;

@Getter
@AllArgsConstructor

@EqualsAndHashCode
@ToString
public class MarkerRequest {
	private final double lat;
	private final double lng;
}
