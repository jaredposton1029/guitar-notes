function drawTrebleClef(canvas, line_spacing) {
  if (!(canvas instanceof HTMLCanvasElement) || !(typeof line_spacing === "number")) {
    return
  }

  console.log(`line_spacing = ${line_spacing}`);

  const ctx = canvas.getContext("2d");
  const CANVAS_HEIGHT = canvas.height;
  const CANVAS_WIDTH = canvas.width;

  let point1 = {
    x: 0.2 * CANVAS_WIDTH,
    y: 0.5 * CANVAS_HEIGHT + 1.5 * line_spacing
  };
  let point2 = {
    x: point1.x - 0.75 * line_spacing,
    y: point1.y
  };
  let point3 = {
    x: point2.x,
    y: 0.5 * CANVAS_HEIGHT
  };
  let point4 = {
    x: point3.x + 0.75 * line_spacing,
    y: point3.y
  };
  ctx.moveTo(point1.x, point1.y);
  ctx.bezierCurveTo(point2.x, point2.y, point3.x, point3.y, point4.x, point4.y);

  point1 = point4;
  point2 = {
    x: point1.x + 2 * line_spacing,
    y: point1.y
  };
  point3 = {
    x: point2.x,
    y: 0.5 * CANVAS_HEIGHT + 2 * line_spacing
  };
  point4 = {
    x: point3.x - 2 * line_spacing,
    y: point3.y
  };
  ctx.moveTo(point1.x, point1.y);
  ctx.bezierCurveTo(point2.x, point2.y, point3.x, point3.y, point4.x, point4.y);

  point1 = point4;
  point2 = {
    x: point1.x - 4 * line_spacing,
    y: 0.5 * CANVAS_HEIGHT + 0.5 * line_spacing
  };
  point3 = {
    x: point1.x + 4 * line_spacing,
    y: 0.5 * CANVAS_HEIGHT - 2 * line_spacing
  };
  point4 = {
    x: point1.x + 0.5 * line_spacing,
    y: 0.5 * CANVAS_HEIGHT - 3.5 * line_spacing
  };
  ctx.moveTo(point1.x, point1.y);
  ctx.bezierCurveTo(point2.x, point2.y, point3.x, point3.y, point4.x, point4.y);

  point1 = point4;
  point2 = {
    x: point1.x - line_spacing,
    y: point1.y + 2.5 * line_spacing
  };
  point3 = {
    x: point2.x + 2 * line_spacing,
    y: 0.5 * CANVAS_HEIGHT + 4.5 * line_spacing
  };
  point4 = {
    x: point3.x - 2 * line_spacing,
    y: point3.y - 2 * line_spacing
  };
  ctx.moveTo(point1.x, point1.y);
  ctx.bezierCurveTo(point2.x, point2.y, point3.x, point3.y, point4.x, point4.y);

  ctx.stroke();
}

function draw() {
  const canvas = document.getElementById("noteCanvas");

  if (!(canvas instanceof HTMLCanvasElement)) {
    return
  }

  const CANVAS_HEIGHT = canvas.height;
  const CANVAS_WIDTH = canvas.width;
  const ctx = canvas.getContext("2d");

  if (!ctx) {
    return
  }

  const LINE_SPACING = 0.08 * CANVAS_HEIGHT;

  // draw staff lines
  for (let i = -2; i < 3; i++) {
    const line_height = 0.5 * CANVAS_HEIGHT + i * LINE_SPACING;
    ctx.moveTo(0.1 * CANVAS_WIDTH, line_height);
    ctx.lineTo(0.9 * CANVAS_WIDTH, line_height);
  }
  ctx.stroke();

  // draw treble clef
  drawTrebleClef(canvas, LINE_SPACING);
}

draw();
