package tech.dhjt.demo.neo4j.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.dhjt.demo.neo4j.entity.Dept;
import tech.dhjt.demo.neo4j.entity.DeptREmployee;
import tech.dhjt.demo.neo4j.entity.Employee;
import tech.dhjt.demo.neo4j.entity.RelationShip;
import tech.dhjt.demo.neo4j.repository.DeptREmployeeRepository;
import tech.dhjt.demo.neo4j.repository.DeptRepository;
import tech.dhjt.demo.neo4j.repository.EmployeeRepository;
import tech.dhjt.demo.neo4j.repository.RelationShipRepository;

/**
 * @description
 * @author DHJT 2023-02-04 16:38:56
 */
@RestController
public class Neo4jController {

    @Resource
    private DeptRepository deptRepository;

    @Resource
    private RelationShipRepository relationShipRepository;

    @Resource
    private EmployeeRepository employeeRepository;

    @Resource
    private DeptREmployeeRepository deptREmployeeRepository;

    // @Autowired
    // private EmployeeService employeeService;

    /**
     * CEO
     *    -设计部
     *       - 设计部经理
     *        - 设计1组
     *           - 李华
     *        - 设计2组
     *           - 张三
     *    -技术部
     *        - 前端技术部
     *           - 前端1
     *           - 前端2
     *           - 前端3
     *        - 后端技术部
     *           - Java1
     *           - Java2
     *           - AI
     *           - 视觉专家
     *        - 测试技术部
     *           - 测试1
     *           - 测试2
     */
    @GetMapping("create")
    public void create() {
        Dept CEO = Dept.builder().deptName("CEO").build();
        Dept dept1 = Dept.builder().deptName("设计部").build();
        Dept dept11 = Dept.builder().deptName("设计1组").build();
        Dept dept12 = Dept.builder().deptName("设计2组").build();

        Dept dept2 = Dept.builder().deptName("技术部").build();
        Dept dept21 = Dept.builder().deptName("前端技术部").build();
        Dept dept22 = Dept.builder().deptName("后端技术部").build();
        Dept dept23 = Dept.builder().deptName("测试技术部").build();

        List<Dept> depts = new ArrayList<>(Arrays.asList(CEO, dept1, dept11, dept12, dept2, dept21, dept22, dept23));
        deptRepository.saveAll(depts);

        // ================================================================
        Employee mCEO = Employee.builder().eNo("1").name("李华").build();
        Employee e1 = Employee.builder().eNo("2").name("张三").build();
        Employee e2 = Employee.builder().eNo("3").name("Java1").build();
        Employee e3 = Employee.builder().eNo("4").name("Java2").build();
        Employee e4 = Employee.builder().eNo("5").name("AI").build();
        Employee e5 = Employee.builder().eNo("6").name("视觉专家").build();
        Employee e6 = Employee.builder().eNo("7").name("测试1").build();
        Employee e7 = Employee.builder().eNo("8").name("测试2").build();
        List<Employee> empleyees = new ArrayList<>(Arrays.asList(mCEO, e1, e2, e3, e4, e5, e6, e7));
        employeeRepository.saveAll(empleyees);

        RelationShip relationShip1 = RelationShip.builder().parent(CEO).child(dept1).build();
        RelationShip relationShip2 = RelationShip.builder().parent(CEO).child(dept2).build();
        RelationShip relationShip3 = RelationShip.builder().parent(dept1).child(dept11).build();
        RelationShip relationShip4 = RelationShip.builder().parent(dept1).child(dept12).build();
        RelationShip relationShip5 = RelationShip.builder().parent(dept2).child(dept21).build();
        RelationShip relationShip6 = RelationShip.builder().parent(dept2).child(dept22).build();
        RelationShip relationShip7 = RelationShip.builder().parent(dept2).child(dept23).build();
        List<RelationShip> relationShips = new ArrayList<>(Arrays.asList(relationShip1, relationShip2, relationShip3,
                relationShip4, relationShip5, relationShip6, relationShip7));
        relationShipRepository.saveAll(relationShips);

        // ====================================================
        DeptREmployee dre1 = DeptREmployee.builder().parent(CEO).child(mCEO).build();
        DeptREmployee dre2 = DeptREmployee.builder().parent(dept11).child(e1).build();
        DeptREmployee dre3 = DeptREmployee.builder().parent(dept12).child(e1).build();
        DeptREmployee dre4 = DeptREmployee.builder().parent(dept21).child(e5).build();
        DeptREmployee dre5 = DeptREmployee.builder().parent(dept21).child(e4).build();
        DeptREmployee dre6 = DeptREmployee.builder().parent(dept21).child(e3).build();
        DeptREmployee dre7 = DeptREmployee.builder().parent(dept21).child(e2).build();
        DeptREmployee dre8 = DeptREmployee.builder().parent(dept22).child(e6).build();
        DeptREmployee dre9 = DeptREmployee.builder().parent(dept23).child(e7).build();

        List<DeptREmployee> list = new ArrayList<>(Arrays.asList(dre1, dre2, dre3, dre4, dre5, dre6, dre7, dre8, dre9));
        deptREmployeeRepository.saveAll(list);
    }

    @GetMapping("rela")
    public RelationShip get(Long id) {
        Optional<RelationShip> byId = relationShipRepository.findById(id);
        return byId.orElse(null);
    }

    @GetMapping("node/e")
    public List<Employee> getEmployee(String name) {
        // List<Employee> findAll =
        // employeeRepository.findByENo(String.valueOf(id));
        List<Employee> findAll = employeeRepository.findByName(name);
        findAll.forEach(e -> System.out.println(e));
        return Optional.of(findAll).orElse(Collections.emptyList());
    }

    // @GetMapping("node/e/search")
    // public List<Employee> search(String name) {
    // return employeeService.findByName(name);
    // }

    @GetMapping("deleteRelationShip")
    public void deleteRelationShip(Long id) {
        relationShipRepository.deleteById(id);
    }

    @GetMapping("deleteDept")
    public void deleteDept(Long id) {
        deptRepository.deleteById(id);
    }

    @GetMapping("deleteAll")
    public void deleteAll() {
        deptRepository.deleteAll();
        relationShipRepository.deleteAll();
        employeeRepository.deleteAll();
        deptREmployeeRepository.deleteAll();
    }

}
