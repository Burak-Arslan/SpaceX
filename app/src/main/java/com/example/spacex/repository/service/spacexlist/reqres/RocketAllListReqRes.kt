package com.example.spacex.repository.service.spacexlist.reqres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RocketAllListResponse(
	val rocketAllList: List<RocketAllListItem?>? = null
):Parcelable

@Parcelize
data class Diameter(
	val feet: Double? = null,
	val meters: Double? = null
):Parcelable

@Parcelize
data class Engines(
	val layout: String? = null,
	val number: Int? = null,
	val propellant1: String? = null,
	val thrustSeaLevel: ThrustSeaLevel? = null,
	val engineLossMax: Int? = null,
	val thrustToWeight: Int? = null,
	val thrustVacuum: ThrustVacuum? = null,
	val isp: Isp? = null,
	val type: String? = null,
	val version: String? = null,
	val propellant2: String? = null
):Parcelable

@Parcelize
data class Thrust(
	val lbf: Int? = null,
	val kN: Int? = null
):Parcelable

@Parcelize
data class Isp(
	val vacuum: Int? = null,
	val seaLevel: Int? = null
):Parcelable

@Parcelize
data class ThrustSeaLevel(
	val lbf: Int? = null,
	val kN: Int? = null
):Parcelable

@Parcelize
data class Height(
	val feet: Double? = null,
	val meters: Double? = null
):Parcelable

@Parcelize
data class Mass(
	val lb: Int? = null,
	val kg: Int? = null
):Parcelable

@Parcelize
data class SecondStage(
	val fuelAmountTons: Double? = null,
	val payloads: Payloads? = null,
	val engines: Int? = null,
	val burnTimeSec: Int? = null,
	val thrust: Thrust? = null,
	val reusable: Boolean? = null
):Parcelable

@Parcelize
data class RocketAllListItem(
	val secondStage: SecondStage? = null,
	val country: String? = null,
	val mass: Mass? = null,
	val active: Boolean? = null,
	val costPerLaunch: Int? = null,
	val description: String? = null,
	val type: String? = null,
	val payloadWeights: List<PayloadWeightsItem?>? = null,
	val firstFlight: String? = null,
	val landingLegs: LandingLegs? = null,
	val diameter: Diameter? = null,
	val flickr_images: List<String>? = null,
	val firstStage: FirstStage? = null,
	val engines: Engines? = null,
	val name: String? = null,
	val stages: Int? = null,
	val boosters: Int? = null,
	val company: String? = null,
	val successRatePct: Int? = null,
	val wikipedia: String? = null,
	val id: String? = null,
	val height: Height? = null
):Parcelable

@Parcelize
data class FirstStage(
	val thrustSeaLevel: ThrustSeaLevel? = null,
	val fuelAmountTons: Double? = null,
	val thrustVacuum: ThrustVacuum? = null,
	val engines: Int? = null,
	val burnTimeSec: Int? = null,
	val reusable: Boolean? = null
):Parcelable

@Parcelize
data class Payloads(
	val compositeFairing: CompositeFairing? = null,
	val option1: String? = null
):Parcelable

@Parcelize
data class CompositeFairing(
	val diameter: Diameter? = null,
	val height: Height? = null
):Parcelable

@Parcelize
data class ThrustVacuum(
	val lbf: Int? = null,
	val kN: Int? = null
):Parcelable

@Parcelize
data class PayloadWeightsItem(
	val lb: Int? = null,
	val name: String? = null,
	val id: String? = null,
	val kg: Int? = null
):Parcelable

@Parcelize
data class LandingLegs(
	val number: Int? = null,
):Parcelable
