
package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;
import domain.Attribute;
import domain.Lessor;
import domain.Property;
import domain.Tenant;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	@Query("select a from Administrator a where a.userAccount.id = ?1")
	Administrator findByUserAccountId(int userAccountId);

	@Query("select avg(l.requests.size) from Lessor l join l.requests r where r.status = 1")
	Double avgNumberOfAcceptedRequestsPerLessor();

	@Query("select avg(l.requests.size) from Lessor l join l.requests r where r.status = 2")
	Double avgNumberOfDeniedRequestsPerLessor();

	@Query("select avg(t.requests.size) from Tenant t join t.requests r where r.status = 1")
	Double avgNumberOfAcceptedRequestsPerTenant();

	@Query("select avg(t.requests.size) from Tenant t join t.requests r where r.status = 2")
	Double avgNumberOfDeniedRequestsPerTenant();

	@Query("select l from Lessor l join l.requests r where r.status = 1 and l.requests.size = (select max(l.requests.size) from Lessor l join l.requests r where r.status = 1)")
	Lessor lessorWhoApprovedMoreRequests();

	@Query("select l from Lessor l join l.requests r where r.status = 2 and l.requests.size = (select max(l.requests.size) from Lessor l join l.requests r where r.status = 2)")
	Lessor lessorWhoDeniedMoreRequests();

	@Query("select l from Lessor l join l.requests r where r.status = 0 and l.requests.size = (select max(l.requests.size) from Lessor l join l.requests r where r.status = 0)")
	Lessor lessorWithMorePendingRequests();

	@Query("select t from Tenant t join t.requests r where r.status = 1 and t.requests.size = (select max(t.requests.size) from Tenant t join t.requests r where r.status = 1)")
	Tenant tenantWhoApprovedMoreRequests();

	@Query("select t from Tenant t join t.requests r where r.status = 2 and t.requests.size = (select max(t.requests.size) from Tenant t join t.requests r where r.status = 2)")
	Tenant tenantWhoDeniedMoreRequests();

	@Query("select t from Tenant t join t.requests r where r.status = 0 and t.requests.size = (select max(t.requests.size) from Tenant t join t.requests r where r.status = 0)")
	Tenant tenantWithMorePendingRequests();

	@Query("")
	Lessor lessorWithMaximumRatio();

	@Query("")
	Lessor lessorWithMinimumRatio();

	@Query("")
	Tenant tenantWithMaximumRatio();

	@Query("")
	Tenant tenantWithMinimumRatio();

	@Query("select avg(f.propertiesFound.size), min(f.propertiesFound.size), max(f.propertiesFound.size) from Finder f group by f")
	Double avgMinMaxNumberOfResultsPerFinder();

	@Query("select min(p.audits.size), avg(p.audits.size), max(p.audits.size) from Property p")
	Double avgMinMaxNumberOfAuditsOfProperty();

	@Query("select p.attributeValues from Property p order by p.attributeValues.size desc")
	List<Attribute> listOfAttributes();

	@Query("select p from Property p join p.lessor l group by l order by p.audits.size")
	List<Property> listOfPropertiesSortedByAudits();

	@Query("select p from Property p join p.lessor l group by l order by p.requests.size")
	List<Property> listOfPropertiesSortedByRequests();

	@Query("select p from Property p join p.requests r where r.status = 1 order by r.size")
	List<Property> listOfPropertiesSortedByApprovedRequests();

	@Query("select p from Property p join p.requests r where r.status = 2 order by r.size")
	List<Property> listOfPropertiesSortedByDeniedRequests();

	@Query("select p from Property p join p.requests r where r.status = 0 order by r.size")
	List<Property> listOfPropertiesSortedByPendingRequests();

	@Query("select min(a.socialIdentities.size), avg(a.socialIdentities.size), max(a.socialIdentities.size) from Actor a")
	Double avgMinMaxOfSocialIdentities();

	@Query("select min(t.invoices.size), avg(t.invoices.size), max(t.invoices.size) from Tenant t")
	Double avgMinMaxOfInvoices();

	@Query("select sum(i.amount) from Invoice i")
	Double totalAmountMoney();

}
