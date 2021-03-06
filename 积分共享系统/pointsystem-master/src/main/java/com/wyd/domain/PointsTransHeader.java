package com.wyd.domain;
// Generated May 3, 2018 2:37:09 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * PointsTransHeader generated by hbm2java
 */
@Entity
@Table(name = "points_trans_header", catalog = "points")
public class PointsTransHeader implements java.io.Serializable {

	private static final long serialVersionUID = 157567466522542824L;
	
	private Integer pointsTransHeaderId;
	private Company company;
	private Membership membership;
	private Integer batchHeaderId;
	private String channelCd;
	private String createdById;
	private Date createdDttm;
	private Date lastUpdatedDttm;
	private String lastUpdatedById;
	private Set<PointsDepositTransDetail> pointsDepositTransDetails = new HashSet<PointsDepositTransDetail>(0);
	private Set<PointsSpendTransDetail> pointsSpendTransDetails = new HashSet<PointsSpendTransDetail>(0);

	public PointsTransHeader() {
	}

	public PointsTransHeader(String createdById, Date createdDttm, Date lastUpdatedDttm, String lastUpdatedById) {
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.lastUpdatedById = lastUpdatedById;
	}

	public PointsTransHeader(Company company, Membership membership, Integer batchHeaderId, String channelCd,
			String createdById, Date createdDttm, Date lastUpdatedDttm, String lastUpdatedById,
			Set<PointsDepositTransDetail> pointsDepositTransDetails,
			Set<PointsSpendTransDetail> pointsSpendTransDetails) {
		this.company = company;
		this.membership = membership;
		this.batchHeaderId = batchHeaderId;
		this.channelCd = channelCd;
		this.createdById = createdById;
		this.createdDttm = createdDttm;
		this.lastUpdatedDttm = lastUpdatedDttm;
		this.lastUpdatedById = lastUpdatedById;
		this.pointsDepositTransDetails = pointsDepositTransDetails;
		this.pointsSpendTransDetails = pointsSpendTransDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "POINTS_TRANS_HEADER_ID", unique = true, nullable = false)
	public Integer getPointsTransHeaderId() {
		return this.pointsTransHeaderId;
	}

	public void setPointsTransHeaderId(Integer pointsTransHeaderId) {
		this.pointsTransHeaderId = pointsTransHeaderId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MEMBERSHIP_ID")
	public Membership getMembership() {
		return this.membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Column(name = "BATCH_HEADER_ID")
	public Integer getBatchHeaderId() {
		return this.batchHeaderId;
	}

	public void setBatchHeaderId(Integer batchHeaderId) {
		this.batchHeaderId = batchHeaderId;
	}

	@Column(name = "CHANNEL_CD", length = 10)
	public String getChannelCd() {
		return this.channelCd;
	}

	public void setChannelCd(String channelCd) {
		this.channelCd = channelCd;
	}

	@Column(name = "CREATED_BY_ID", nullable = false, length = 100)
	public String getCreatedById() {
		return this.createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DTTM", nullable = false, length = 19)
	public Date getCreatedDttm() {
		return this.createdDttm;
	}

	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DTTM", nullable = false, length = 19)
	public Date getLastUpdatedDttm() {
		return this.lastUpdatedDttm;
	}

	public void setLastUpdatedDttm(Date lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}

	@Column(name = "LAST_UPDATED_BY_ID", nullable = false, length = 100)
	public String getLastUpdatedById() {
		return this.lastUpdatedById;
	}

	public void setLastUpdatedById(String lastUpdatedById) {
		this.lastUpdatedById = lastUpdatedById;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pointsTransHeader")
	@XmlTransient
	public Set<PointsDepositTransDetail> getPointsDepositTransDetails() {
		return this.pointsDepositTransDetails;
	}

	public void setPointsDepositTransDetails(Set<PointsDepositTransDetail> pointsDepositTransDetails) {
		this.pointsDepositTransDetails = pointsDepositTransDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pointsTransHeader")
	@XmlTransient
	public Set<PointsSpendTransDetail> getPointsSpendTransDetails() {
		return this.pointsSpendTransDetails;
	}

	public void setPointsSpendTransDetails(Set<PointsSpendTransDetail> pointsSpendTransDetails) {
		this.pointsSpendTransDetails = pointsSpendTransDetails;
	}

}
